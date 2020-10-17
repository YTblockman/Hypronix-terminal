package hypronix.dev.commands;

import hypronix.dev.Main;

public class cmd {
    private static String last;
    public static String getCmd(){
        return last;
    }
    public static void setCmd(String str){
        last = str;
        Main.reloadCmd();
    }
}
