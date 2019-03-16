import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NetClass {
	
	public static void main(String[] args) {
		/*try {
			URL url = new URL("https://google.com/");
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}*/
		
		try {
			URL url = new URL("https://music.youtube.com/");
			URLConnection connection = url.openConnection();
			InputStream input = connection.getInputStream();
			ReadableByteChannel channel = Channels.newChannel(input);
			ByteBuffer buffer = ByteBuffer.allocate(64);
			String line = null;
			while(channel.read(buffer) > 0) {
				System.out.println(new String(buffer.array()));
				buffer.clear();
			}
		} catch(IOException io) {
			
		}
	}

}
