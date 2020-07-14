package lyq.mq.RocketMq.product;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Producer {

   public static void main(String[] args) throws Exception {
       DefaultMQProducer producer = new DefaultMQProducer("order_product");

       producer.setNamesrvAddr("152.136.152.40:9876");

       producer.start();

       String[] tags = new String[]{"TagA", "TagC", "TagD"};

       // �����б�
       List<OrderStep> orderList = new Producer().buildOrders();

       Date date = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String dateStr = sdf.format(date);
       for (int i = 0; i < 40; i++) {
           // �Ӹ�ʱ��ǰ׺
           String body = dateStr + " Hello RocketMQ " + orderList.get(i);
           Message msg = new Message("0710Order", tags[i % tags.length], "KEY" + i, body.getBytes());

           int finalI = i;
           SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
               @Override
               public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                   Long id = (Long) arg;  //���ݶ���idѡ����queue
                   long index = id % mqs.size();
                   return mqs.get((int) index);
               }
           }, orderList.get(i).getOrderId());//����id

           System.out.println(String.format("SendResult status:%s, queueId:%d, body:%s",
               sendResult.getSendStatus(),
               sendResult.getMessageQueue().getQueueId(),
               body));
       }

       producer.shutdown();
   }

   /**
    * �����Ĳ���
    */
   private static class OrderStep {
       private long orderId;
       private String desc;

       public long getOrderId() {
           return orderId;
       }

       public void setOrderId(long orderId) {
           this.orderId = orderId;
       }

       public String getDesc() {
           return desc;
       }

       public void setDesc(String desc) {
           this.desc = desc;
       }

       @Override
       public String toString() {
           return "OrderStep{" +
               "orderId=" + orderId +
               ", desc='" + desc + '\'' +
               '}';
       }
   }

   /**
    * ����ģ�ⶩ������
    */
   private List<OrderStep> buildOrders() {
       List<OrderStep> orderList = new ArrayList<OrderStep>();


       OrderStep orderDemo = new OrderStep();

       for (int i = 0; i < 10; i++) {
           orderDemo = new OrderStep();
           orderDemo.setOrderId(i);
           orderDemo.setDesc("����");
           orderList.add(orderDemo);
       }
       for (int i = 10; i < 20; i++) {
           orderDemo = new OrderStep();
           orderDemo.setOrderId(i);
           orderDemo.setDesc("����");
           orderList.add(orderDemo);
       }
       for (int i = 20; i < 30; i++) {
           orderDemo = new OrderStep();
           orderDemo.setOrderId(i);
           orderDemo.setDesc("����");
           orderList.add(orderDemo);
       }
       for (int i = 30; i < 40; i++) {
           orderDemo = new OrderStep();

           orderDemo.setOrderId(i);
           orderDemo.setDesc("���");
           orderList.add(orderDemo);
       }

       return orderList;
   }
}