import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      ICanvas canvas = new Canvas(9, 6);
      
      List<ICommandMatcher> commandMatchers = new ArrayList<ICommandMatcher>();
      
      HelpCommandMatcher helpCommandMatcher = new HelpCommandMatcher();
      commandMatchers.add(helpCommandMatcher); 
      commandMatchers.add(new DotCommandMatcher(canvas));
      commandMatchers.add(new FillCommandMatcher(canvas));
      commandMatchers.add(new ClearCommandMatcher(canvas));
      commandMatchers.add(new PrintCanvasCommandMatcher(canvas));
      commandMatchers.add(new ExitCommandMatcher()); 
      commandMatchers.add(new UnrecognizedCommandMatcher()); 

      helpCommandMatcher.run();
      
      while (scanner.hasNextLine()) {
         String command = scanner.nextLine();
         
         ICommandMatcher commandMatcher = findCommand(commandMatchers, command);
         
         if (commandMatcher == null) {
            throw new IllegalArgumentException("Command not found.");
         }
         
         commandMatcher.run();
      }
   }
   
   public static ICommandMatcher findCommand(Iterable<ICommandMatcher> commandMatchers, String command) {
      for (ICommandMatcher commandMatcher : commandMatchers) {
         if (commandMatcher.match(command)) return commandMatcher;
      }
            
      return null;
   }
}