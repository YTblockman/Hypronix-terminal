package hypronix.dev.commands;

@SuppressWarnings("serial")
public class AlreadyRegisteredException extends Exception{
    public AlreadyRegisteredException(String message) {
        super("Command: " + message + " is already registered");
    }
}
