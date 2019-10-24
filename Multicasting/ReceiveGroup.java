import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class ReceiveGroup extends Thread{
	InetAddress group;
	MulticastSocket s;
	
	ReceiveGroup(InetAddress group, MulticastSocket s){
		this.group= group;
		this.s = s;
	}
	public void run(){
		byte buf[] = new byte[1000];
		DatagramPacket recieve = new DatagramPacket(buf, buf.length);
		while(true){
				try {
					s.receive(recieve);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String str = new String(recieve.getData());
				System.out.println(str + recieve.getPort());
		}
	}
}
