import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	public static void main(String args[]) throws Exception{
			//InetAddress inet= InetAddress.getByName("localhost");
			Socket s= new Socket("localhost",9999);
			DataInputStream din =  new DataInputStream(s.getInputStream());
			//System.out.println(din.readUTF());
			DataOutputStream dou = new DataOutputStream(s.getOutputStream());
			String st;
			int count=6;
			while(count>=0){
				st=din.readUTF();
				System.out.println(st);
				count--;
			}
			String str;
			Scanner sc=new Scanner(System.in);
			str=sc.nextLine();
			dou.writeUTF(str);
			File file=new File("C:/suvid/Client/src/files/"+str);
			FileOutputStream fos=new FileOutputStream("C:/suvid/Client/src/files/"+str);
			int i=din.read();
			while(i!=-1){
				fos.write(i);
				i=din.read();
			}
			fos.close();
			sc.close();
			s.close();
	}
}
