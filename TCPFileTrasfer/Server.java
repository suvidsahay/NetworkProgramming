import java.awt.List;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public static void main(String args[])throws Exception{
		int port = 9999;
			ServerSocket ss = new ServerSocket(port);
			//List<Socket> clients=new ArrayList<>(); 
			while(true){
				Socket s = ss.accept();
				MultiServers t1=new MultiServers(s);
				t1.start();
			}
	}
}
