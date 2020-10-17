package hypronix.dev.commands;

public abstract class Command {
    public abstract void onCall(String args);

    public abstract String getCallString();
}
