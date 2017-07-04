/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beacon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class FrontEnd {
    static int portNumber = 5000; 
    public static void main(String[] args){
        
        
        frontBeacon();
        
    }
    
    private static void frontBeacon(){
        try {
            
            String status="";
            ServerSocket serversock = new ServerSocket(portNumber);
            
            do{
                Thread.sleep(1500);
                System.out.println("Nueva Pasada");
                Socket socket = serversock.accept();
                
                
                PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           
                status=in.readLine();
                System.out.println("backEnd dice: "+status);
     
                
            }while(true);
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
