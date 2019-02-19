package cn.gamers.filter;

import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
  
public class HttpSessionListenerTest implements HttpSessionListener {  
  
    public void sessionCreated(HttpSessionEvent arg0) {  
        // TODO Auto-generated method stub  
  
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"); 
    }  
  
    public void sessionDestroyed(HttpSessionEvent arg0) {  
        // TODO Auto-generated method stub  
  
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");  
    }  
  
}  