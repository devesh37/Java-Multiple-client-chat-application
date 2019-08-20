import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;
	

class ClientMain
{
	
	public static void main(String[] args) throws Exception
	{
	Socket client=new Socket("13.233.159.61",8999);
	DataInputStream din=new DataInputStream(client.getInputStream());
	DataOutputStream dout=new DataOutputStream(client.getOutputStream());
	Scanner S=new Scanner(System.in);
	String msg="";
	System.out.println("Write Message to Server:");
	while(!(msg=S.nextLine()).equals("over"))
	{
		
	dout.writeUTF(msg);
	dout.flush();
				System.out.println("Waiting for server response:");
		msg=din.readUTF();
		System.out.println("Message from Server:"+msg);
			System.out.println("Write Message to Server:");
	}
	
	
	S.close();
	
    }
}