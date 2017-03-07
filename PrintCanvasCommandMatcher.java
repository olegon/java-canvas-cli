public class PrintCanvasCommandMatcher implements ICommandMatcher {
   private ICanvas canvas;
   
   public PrintCanvasCommandMatcher(ICanvas canvas) {
      this.canvas = canvas;
   }

   public boolean match(String command) {
      return command.matches("^print$");
   }
   
   public void run() {
      System.out.print(canvas);
      System.out.println("> done.");
   }
}