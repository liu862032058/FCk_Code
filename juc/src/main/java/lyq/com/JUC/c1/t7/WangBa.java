package lyq.com.JUC.c1.t7;

import java.util.concurrent.DelayQueue;

public class WangBa implements Runnable {
 
    private DelayQueue<Man> queue = new DelayQueue<Man>();
    
    public boolean yingye =true;  
    
    /**
     * �ϻ� 
     */
    public void shangji(String name,String id,int money){
        Man man = new Man(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("����"+man.getName()+" ���֤"+man.getId()+"��Ǯ"+money+"��,��ʼ�ϻ�...");  
        this.queue.add(man);  
    }  
    
    // �»�
    public void xiaji(Man man){
        System.out.println("����"+man.getName()+" ���֤"+man.getId()+"ʱ�䵽�»�...");  
    }  
  
    @Override  
    public void run() {  
        while(yingye){  
            try {
                Man man = queue.take();
                xiaji(man);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    public static void main(String args[]){  
        try{  
            System.out.println("���ɿ�ʼӪҵ");  
            WangBa siyu = new WangBa();  
            Thread shangwang = new Thread(siyu);  
            shangwang.start();  
              
            siyu.shangji("·�˼�", "123", 1);  
            siyu.shangji("·����", "234", 2);
            siyu.shangji("·�˱�", "345", 3);
        }  
        catch(Exception e){  
            e.printStackTrace();
        }  
  
    }  
}