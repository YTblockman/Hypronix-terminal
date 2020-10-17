package hypronix.dev.commands;

import java.util.HashMap;

public class CommandHandler {

    private static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void register(Command cmd) throws Exception {
        if(commands.containsValue(cmd) || commands.containsKey(cmd.getCallString())){
            throw new AlreadyRegisteredException(cmd.toString() + " with command: " + cmd.getCallString());
        }else{
            commands.put(cmd.getCallString(), cmd);
        }
    }

    public static void ranCmd(String str) throws CommandDoesNotExistException {
        try {
            commands.get(str).onCall(str);
        }catch (Exception e){
            throw new CommandDoesNotExistException(str);
        }

    }
}
