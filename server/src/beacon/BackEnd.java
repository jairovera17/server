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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class BackEnd {
    static int portNumber = 5000;
    static String hostname = "127.0.0.1";
    public static void main(String[] args){
        
        backBeacon();
    }
    
    private static void  backBeacon(){
        
        try {
            
            do{
            Socket backSocket = new Socket(hostname,portNumber);
            PrintWriter out = new PrintWriter(backSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(backSocket.getInputStream()));
            
            out.println("memes listos :v");
            
            
            }while(true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
