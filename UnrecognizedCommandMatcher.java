public class UnrecognizedCommandMatcher implements ICommandMatcher {

   public boolean match(String command) {
      return true;
   }
   
   public void run() {
      System.out.println("Unrecognized command. Type \"help\" for help.");
   }
}