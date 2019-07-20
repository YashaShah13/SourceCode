import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int receiveItem, result;

		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8992);
		Socket socket = serverSocket.accept();

		Scanner sc = new Scanner(socket.getInputStream());
		receiveItem = sc.nextInt();
		result = receiveItem * receiveItem;

		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println(result);

		socket.close();

	}
}
