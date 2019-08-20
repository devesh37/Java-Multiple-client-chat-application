import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;






class ServerMain
{
	
	public static void main(String[] args) throws Exception
	{
	
	ServerSocket ss=new ServerSocket(8999);
	System.out.println("Server Is Listening:");
	Socket server=ss.accept();
	DataInputStream din=new DataInputStream(server.getInputStream());
	DataOutputStream dout=new DataOutputStream(server.getOutputStream());
	Scanner S=new Scanner(System.in);
	String msg="";
	
		try{
	while(true)
	{
	System.out.println("Waiting for Client Reponse:");	
	msg=din.readUTF();
	if(msg.equals("over"))
	{
		dout.writeUTF("over");
		break;	
	}
		System.out.println("Message from Client:"+msg);
		System.out.print("Write Something to Client:");
			msg=S.nextLine();
		dout.writeUTF(msg);	
		dout.flush();
	
	}
		}
		catch(Exception e)
		{
			
			System.out.println("Client Gone Connection closed!!");
		}
		
	finally{
	server.close();
	}
    }
}