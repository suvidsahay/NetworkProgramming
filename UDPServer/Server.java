package udpSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server  {
	public static void main (String args[]) throws Exception{
		InetAddress inet=InetAddress.getByName("localhost");
		DatagramSocket ds = new DatagramSocket(9999,inet);
		byte[] buf = new byte[100];
		DatagramPacket dp = new DatagramPacket(buf,100);
		ds.receive(dp);
		String st= new String(dp.getData());
		System.out.println(st);
		String str="Hello from Server";
		
		DatagramPacket dp2=new DatagramPacket(str.getBytes(),str.length(),dp.getAddress(),dp.getPort());
		
		ds.send(dp2);
		
	}
}
