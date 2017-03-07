public class HelpCommandMatcher implements ICommandMatcher {

   public boolean match(String command) {
      return command.matches("help");
   }
   
   public void run() {
      System.out.println("Commands available:");
      System.out.println("\thelp: show help menu.");
      System.out.println("\tdot x y: fill the point (x, y).");
      System.out.println("\tfill x y: fill the region at (x, y).");
      System.out.println("\tclear x y: clear the point (x, y).");
      System.out.println("\texit: exit program.");
   }

}