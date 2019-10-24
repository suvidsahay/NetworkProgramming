package udpSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	public static void main(String args[]) throws Exception{
		InetAddress inet=InetAddress.getByName("localhost");
		DatagramSocket ds = new DatagramSocket();
		String str= "Hello from Client";
		DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),inet,9999);
		byte[] buf = new byte[100];
		DatagramPacket dp2 = new DatagramPacket(buf,100);
		ds.send(dp);
		ds.receive(dp2);
		String st= new String(buf);
		System.out.println(st);
	}
	
}
