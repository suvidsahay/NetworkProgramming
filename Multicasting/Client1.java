import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class Client1 {
	public static void main(String args[]) throws Exception{
		InetAddress group = InetAddress.getByName("228.5.6.7");
		MulticastSocket s = new MulticastSocket(6789);
		//MulticastSocket s = new MulticastSocket(6790);
		s.joinGroup(group);
		Scanner sc = new Scanner(System.in);
		ReceiveGroup rg = new ReceiveGroup(group , s);
		rg.start();
		while(true){
			String message = sc.nextLine();
			DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(),group,6789);
			//DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(),group,6790);
			s.send(dp);
		}
		
	}
}
	
