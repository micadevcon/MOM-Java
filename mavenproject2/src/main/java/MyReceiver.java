import javax.jms.*;  
import javax.naming.InitialContext;  
  
public class MyReceiver {  
    public static void main(String[] args) {  
        try{  

            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  

            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  

            Queue t=(Queue)ctx.lookup("myQueue");  

            QueueReceiver receiver=ses.createReceiver(t);  
              

            MyListener listener=new MyListener();  
              
            
            receiver.setMessageListener(listener);  
              
            System.out.println("Приемник 1 готов, ожидает сообщений...");  
            System.out.println("Ctrl +c для завершения работы...");  
            while(true){                  
                Thread.sleep(1000);  
            }  
        }catch(Exception e){System.out.println(e);}  
    }  
  
}  