import java.util.Random;
import java.util.Scanner;

public class Program {
	static boolean running = true;
	public static Scanner scan;
	public static String[] type;
	public static String[] premise;
	public static String[] conclusion;
			
	public static void main(String[] args) {
		Random rand = new Random();
		scan = new Scanner(System.in);
		type = new String[]{"Modus Ponens", "Modus Tollens", "Process of Elimination", "Chain Rule"}; 
		premise = new String[]{"I study hard"};
		conclusion = new String[]{"I will get an A"};
		menu();
	
		while(running) {
			try {
				System.out.print("\nSelect argument: ");
				String selection = scan.next();
				if(Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 8)
				{
					System.err.println("\nSelection must be within range\n");
				}
				else if(Integer.parseInt(selection) >= 1 && Integer.parseInt(selection) <= 7)
					System.out.println("\nYou have selected: "+type[Integer.parseInt(selection)-1]);
				else if(Integer.parseInt(selection) == 8) {
					System.out.println("Goodbye");
					System.exit(1);
				}
				else
					System.err.println("You entered invalid input, please try again");
				if(Integer.parseInt(selection) == 1) {
					String prem = premise[rand.nextInt(premise.length)];
					String conc = conclusion[rand.nextInt(conclusion.length)];
					System.out.println(prem +". if "+prem+", then "+conc+". "+"Therefore, "+conc);
				}
			}catch(Exception e) {
				System.err.println("\nPlease select a valid argument\n");
			}
			
		}
		
	}
	
	public static void menu() {
		System.out.println("Please select which type of argument to generate by entering the associated number.\n");
		for(int i = 0; i < type.length; i++) {
			System.out.println((i+1)+". "+type[i]);
		}
		System.out.println("8. Quit");
	}
}
