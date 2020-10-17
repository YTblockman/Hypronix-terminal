package hypronix.dev.commands;

@SuppressWarnings("serial")
public class CommandDoesNotExistException extends Exception{
    public CommandDoesNotExistException(String message) {
        super("Command: " + message + " Does not exist");
    }
}
