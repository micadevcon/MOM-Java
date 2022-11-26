import javax.jms.*;  
public class MyListener implements MessageListener {  
  
    public void onMessage(Message m) {  
        try{  
        TextMessage msg=(TextMessage)m;  
      
        System.out.println("Полученное сообщение:"+msg.getText());  
        }catch(JMSException e){System.out.println(e);}  
    }  
}  