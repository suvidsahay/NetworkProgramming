import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class InetExplore {
	public static void main(String args[]){
		System.out.println();
		Scanner sc=new Scanner(System.in);
		byte[] ipAddr = new byte[] { (byte) 172, (byte) 16,(byte) 87,(byte) 46 };  
		try {
			InetAddress ip=InetAddress.getByAddress(ipAddr);
			System.out.println("Host name "+ip.getCanonicalHostName());
			System.out.println("IP Address "+ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
