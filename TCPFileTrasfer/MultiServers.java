import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;


public class MultiServers extends Thread {
	Socket s;

	public MultiServers(Socket s1){
		s=s1;

	}
	public void run(){
		DataOutputStream ds;
		try {
			ds = new DataOutputStream(s.getOutputStream());
			ds.writeUTF("Hello from the server.Enter the name of the file you want to download");
			DataInputStream in = new DataInputStream(s.getInputStream());
			File folder=new File("C:/suvid/Server/src/files");
			File[] files= folder.listFiles();
			for(int i = 0; i<files.length;i++){
				ds.writeUTF(files[i].getName());
			}
			String st=in.readUTF();
			FileInputStream file= new FileInputStream("C:/suvid/Server/src/files/"+st);
			int i=0;
			while(i!=-1){
				i=file.read();
				ds.write(i);
			}
			ds.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
}
