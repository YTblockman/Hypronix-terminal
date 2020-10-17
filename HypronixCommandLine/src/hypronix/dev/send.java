package hypronix.dev;

import com.sline.setup.Setup;
import com.sline.windowlisteners.NewButtonListener;
import hypronix.dev.commands.CommandDoesNotExistException;
import hypronix.dev.commands.CommandHandler;
import hypronix.dev.commands.cmd;

import java.awt.event.ActionEvent;

class run extends NewButtonListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        send.setConsole(Setup.getBoolFromCheckBox(Main.getMainBox()));
        cmd.setCmd(Setup.getStringFromInBar(Main.getMainBar()));
        try {
            CommandHandler.ranCmd(Setup.getStringFromInBar(Main.getMainBar()));
        } catch (CommandDoesNotExistException commandDoesNotExistException) {
            commandDoesNotExistException.printStackTrace();
        }
    }

    @Override
    public String getButtonName() {
        return "null";
    }
}

public class send{
    private static boolean console;
    public static void setup(){
        Setup.createButton("Send", new run(), Setup.getGlobalPanel());
    }
    public static void setConsole(boolean state){
        console = state;
    }
    public static boolean getConsole(){
        return console;
    }


    public static void btn(){
        Setup.createButton("Send", new sender(), Setup.getGlobalPanel());
    }
}