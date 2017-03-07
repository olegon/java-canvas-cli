import java.util.regex.*;

public class DotCommandMatcher implements ICommandMatcher {
    private ICanvas canvas;
    private String command;
    private final String regexString = "^dot\\s+(\\d+)\\s+(\\d+)$";

    public DotCommandMatcher(ICanvas canvas) {
        this.canvas = canvas;
    }

    public boolean match(String command) {
        this.command = command;
        return command.matches(regexString);
    }

    public void run() {
        Matcher m = Pattern.compile(regexString).matcher(command);

        while (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            
            try {
                canvas.dot(x - 1, y - 1);
                System.out.println("> done.");
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Os índices estão fora do Canvas.");
            }
        }
    }
}