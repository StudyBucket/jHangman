import operation.CLI;

public class JHangman {

	public static void main(String[] args) {
		System.out.println("*** jHangman ***");
		System.out.println("Starting ...");
		System.out.println("No UI available. Starting CLI ...");

		CLI cli = new CLI();
		cli.start();
		
		System.out.print("\n\n");
		System.out.println("*** Thanks for playin' ***");
		System.out.println("Exiting ...");
		System.exit(0);		
	}

}