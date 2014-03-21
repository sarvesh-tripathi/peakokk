package com.peakokk.location;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetLocation

{

    public static void main(String args[]) throws UnknownHostException {
        
      System.out.println(InetAddress.getLocalHost().getHostAddress());
        
        
        /*HttpServletRequest httpRequest = (HttpServletRequest) request;
        String userIpAddress = httpRequest.getHeader("X-Forwarded-For");
        
        if (userIpAddress == null) {
            userIpAddress = httpRequest.getRemoteAddr();
        }*/
        
        
        
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
         
        String ipAddress = req.getRemoteAddr();
        
    }
    
    
}



