import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int sendItem, receivedItem;
		Scanner scanner = new Scanner(System.in);

		Socket socket = new Socket("127.0.0.1", 8992);
		Scanner socketScanner = new Scanner(socket.getInputStream());
		System.out.println("Input:");

		sendItem = scanner.nextInt();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println(sendItem);

		receivedItem = socketScanner.nextInt();
		System.out.println("Output: " + receivedItem);

		socket.close();
	}

}
