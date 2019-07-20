import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int sendItem, tp;
		Scanner sc = new Scanner(System.in);

		Socket socket = new Socket("127.0.0.1", 8992);
		Scanner sc1 = new Scanner(socket.getInputStream());
		System.out.println("Input:");

		sendItem = sc.nextInt();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println(sendItem);

		tp = sc1.nextInt();
		System.out.println("Output: " + tp);

		socket.close();
	}

}
