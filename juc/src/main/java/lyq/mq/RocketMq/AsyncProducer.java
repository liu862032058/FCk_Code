package lyq.mq.RocketMq;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 2�������첽��Ϣ
 *
 * �첽��Ϣͨ�����ڶ���Ӧʱ�����е�ҵ�񳡾��������Ͷ˲������̳�ʱ��صȴ�Broker����Ӧ��
 */
public class AsyncProducer {


    public static void main(String[] args) throws Exception {
        // ʵ������Ϣ������Producer
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        // ����NameServer�ĵ�ַ
        producer.setNamesrvAddr("152.136.152.40:9876");
        // ����Producerʵ��
        producer.start();
//        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            // ������Ϣ����ָ��Topic��Tag����Ϣ��
            Message msg = new Message("TopicAsyncTest",
                    "TagA",
                    "OrderID188"+i,
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // SendCallback�����첽���ؽ���Ļص�
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("���ͳɹ�");
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.println("����ʧ��");
                    System.out.printf("%-10d Exception %s %n", index, e);

                    e.printStackTrace();
                }
            });
        }
        // ������ٷ�����Ϣ���ر�Producerʵ����
        producer.shutdown();
    }
}
