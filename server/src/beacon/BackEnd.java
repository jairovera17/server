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
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class BackEnd {
    static int id = 10;
    static int portNumber = 5000;
    static String hostname = "127.0.0.1";
    static String localname = "127.0.0.10";
    static backEndStatus backStatus;
    
    public static void main(String[] args){
        
        backStatus = new backEndStatus(new Random().nextInt()%100+1000, localname, 0);
        backBeacon();
    }
    
    private static void  backBeacon(){
        String ack="";
        try {
            
            do{
            Socket backSocket = new Socket(hostname,portNumber);
            PrintWriter out = new PrintWriter(backSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(backSocket.getInputStream()));
            
            backStatus.lastLog=System.currentTimeMillis();
            
            
            out.println(backStatus.toString());
            ack = in.readLine();
            System.out.println("Front dice: "+ack);
            
            
            }while(true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
