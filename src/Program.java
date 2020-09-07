import java.util.Random;
import java.util.Scanner;

public class Program {
	static boolean running = true;
	public static Scanner scan;
	public static String[] type;
	public static String[] premise;
	public static String[] conclusion;
  public static String[] auth;
  public static boolean auto = false;
  public static String mode = "";
			
	public static void main(String[] args) {
		Random rand = new Random();
		scan = new Scanner(System.in);
		type = new String[]{"Modus Ponens", "Modus Tollens", "Process of Elimination", "Chain Rule", "Affirming the Consequent", "Denying the Antecedent", "Begging the Question"}; 
		premise = new String[]{"I study hard", "you have a current password", "it is raining", "it is after 10PM", "the weather is nice", "the dog is barking", "the house is on fire", "you work hard", "you stay inside all day", "you participate in the race", "you take the new position"};
		conclusion = new String[]{"I will get an A", "you can log on to the network", "the road will get wet", "the store will be closed", "Joe will take a walk", "the neighbors will get mad", "everything is ruined", "you will pass the test", "you will get the job", "long distance space travel is possibe", "the stock market will crash"};
    auth = new String[]{"The boss says", "My father told me that", "According to the news", "According to the internet", "Scientists agree that", "Elon Musk assures us that", "It has been proven that"};

		
	
		while(running) {
			try {
        menu();
				System.out.print("\nSelect argument: ");
				String selection = scan.next();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
				if(Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 8)
				{
					System.err.println("\nSelection must be within range\n");
				}
				else if(Integer.parseInt(selection) >= 1 && Integer.parseInt(selection) <= 7){
					System.out.println("\nYou have selected: "+type[Integer.parseInt(selection)-1]);
          System.out.print("\n1. Automatic\n2. User input:\n\nSelect mode: ");
				  mode = scan.next(); 
          scan.nextLine();
        }
				else if(Integer.parseInt(selection) == 8) {
					System.out.println("Goodbye");
					System.exit(1);
				}
				else
					System.err.println("You entered invalid input, please try again");
        
        String autho = auth[rand.nextInt(auth.length)];
        if(Integer.parseInt(mode) == 1)
          auto = true; 
        else
          auto = false;
				if(Integer.parseInt(selection) == 1) {
          String prem = "";
					String conc = "";
          if(auto){
            prem = premise[rand.nextInt(premise.length)];
					  conc = conclusion[rand.nextInt(conclusion.length)];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter a conclusion: ");
					  conc = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
					System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", if "+prem+", then "+conc+". " +prem+", therefore, "+conc+".\"");
          end();
				}
        if(Integer.parseInt(selection) == 2){
          String prem = "";
					String conc = "";
          if(auto){
            prem = premise[rand.nextInt(premise.length)];
					  conc = conclusion[rand.nextInt(conclusion.length)];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter a conclusion: ");
					  conc = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
					System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", if "+prem+", then "+conc+". It is not the case that " +prem+", therefore, it is not the case that "+conc+".\"");
          end();
        }
        if(Integer.parseInt(selection) == 3){
          int prem1int = rand.nextInt(premise.length);
          int prem2int = rand.nextInt(premise.length);
          String prem = "";
          String prem2 = "";
          if(auto){
            while(prem1int == prem2int){
              prem2int = rand.nextInt(premise.length);
            }
            prem = premise[prem1int];
            prem2 = premise[prem2int];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter another premise: ");
            prem2 = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
          
          int flip = rand.nextInt(2);
          if(flip == 1){
            System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", it is either the case that "+prem+" or, "+prem2+". It is not the case that " +prem+", therefore, "+prem2+".\"");
          }
          else{
            System.out.println("\"\n"+auth[rand.nextInt(auth.length)]+", it is either the case that "+prem+" or, "+prem2+". It is not the case that " +prem2+", therefore, "+prem+".\"");
          }
          end();
        }
        if(Integer.parseInt(selection) == 4){
          int prem1int = rand.nextInt(premise.length);
          int prem2int = rand.nextInt(premise.length);
          int prem3int = rand.nextInt(premise.length);
          String prem = "";
          String prem2 = "";
          String prem3 = "";
          if(auto){
            while(prem1int == prem3int){
              prem2int = rand.nextInt(premise.length);
              prem3int = rand.nextInt(premise.length);
            }
            prem = premise[prem1int];
            prem2 = conclusion[prem2int];
            prem3 = premise[prem3int];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter another premise: ");
            prem2 = scan.nextLine();
            System.out.print("\nEnter one more premise: ");
            prem3 = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
          System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", if "+prem+", then "+prem2+". If "+prem2+", then "+prem3+". "+prem+", therefore, "+prem3+".\"");
          end();
        }
        if(Integer.parseInt(selection) == 5){
          String prem = "";
					String conc = "";
          if(auto){
            prem = premise[rand.nextInt(premise.length)];
					  conc = conclusion[rand.nextInt(conclusion.length)];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter a conclusion: ");
					  conc = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
					System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", if "+prem+", then "+conc+". " +conc+", therefore, "+prem+".\"");
          end();
        }
        if(Integer.parseInt(selection) == 6){
          String prem = "";
					String conc = "";
          if(auto){
            prem = premise[rand.nextInt(premise.length)];
					  conc = conclusion[rand.nextInt(conclusion.length)];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
            System.out.print("\nEnter a conclusion: ");
					  conc = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
					System.out.println("\n\""+auth[rand.nextInt(auth.length)]+", if "+prem+", then "+conc+". It is not the case that " +conc+", therefore, it is not the case that "+prem+".\"");
          end();
        }
        if(Integer.parseInt(selection) == 7){
          String prem = "";
          if(auto){
            prem = premise[rand.nextInt(premise.length)];
          }else{
            System.out.print("\nEnter a premise: ");
            prem = scan.nextLine();
          }
          System.out.println("\nGenerated argument: ");
					System.out.println("\n\""+prem+", therefore, "+prem+".\"");
          end();
        }
			}catch(Exception e) {
				System.err.println("\nPlease select a valid argument\n" + e.getMessage());
			}
			
		}
		
	}
	
	public static void menu() {
		System.out.println("\nPlease select which type of argument to generate by entering the associated number.\n");
		for(int i = 0; i < type.length; i++) {
			System.out.println((i+1)+". "+type[i]);
		}
		System.out.println("8. Quit");
	}

  public static void end(){
    try{
      System.out.println("\nPress Enter key to continue: ");
		  System.in.read();
      System.out.print("\033[H\033[2J");  
      System.out.flush();
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
  }
}
