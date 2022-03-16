import java.io.*;  
import java.net.*;  
public class MyServer {  
    public static void main(String[] args){  
        try{  
            ServerSocket ss=new ServerSocket(6666);  
            Socket s=ss.accept();//establishes connection   
            
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());   
            
            String  str=(String)dis.readUTF();  
            System.out.println("Client message= "+str);
            
            dout.writeUTF("GDAY");
            dout.flush();

            str = dis.readUTF();  
            System.out.println("Client message= "+str);
            dout.flush();

            dout.writeUTF("BYE");
            dout.flush();
            
            ss.close();  
        }catch(Exception e){System.out.println(e);}  
    }  
}  