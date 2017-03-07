public class ExitCommandMatcher implements ICommandMatcher {

   public boolean match(String command) {
      return command.matches("^exit$");
   }
   
   public void run() {
      System.exit(0);
   }

}