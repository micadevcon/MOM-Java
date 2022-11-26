import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import javax.naming.*;  
import javax.jms.*;  
  
public class MySender {  
    public static void main(String[] args) {  
        try  
        {    
            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
        
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
        
            Queue t=(Queue)ctx.lookup("myQueue");  
               
            QueueSender sender=ses.createSender(t);  
  
            TextMessage msg=ses.createTextMessage();  
              

            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
            while(true)  
            {  
                System.out.println("Введите сообщение");  
                String s=b.readLine();  
                if (s.equals("end"))  
                    break;  
                msg.setText(s);  

                sender.send(msg);  
                System.out.println("Сообщение отправлено");  
            }  
 
            con.close();  
        }catch(Exception e){System.out.println(e);}  
    }  
}  