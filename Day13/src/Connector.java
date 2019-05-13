import java.io.InputStream;
import java.net.URL;

public class Connector {
	
	public static void main(String[] args) throws Exception{
		
		for(int i = 0; i< 300; i++) {
			
			new Thread(
					//dd
					()->{
						try {
							URL url = new URL("http://192.168.41.43:8080/web1/hello.jsp");
							
							InputStream in = url.openStream();
							byte[] arr = new byte[8192];
							in.read(arr);
							System.out.println(new String(arr));
						}catch(Exception e) {
					}
					
					}
					
					).start();
			
			
		}
	}

}
