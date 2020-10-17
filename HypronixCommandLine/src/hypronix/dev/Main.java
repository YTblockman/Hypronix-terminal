/**
 * PROJECT REGISTERED TO YTBLOCKMAN [HYPRONIXDEV]
 *
 * @NAME : HYPRONIX DEV
 * @PROJECT_BUILD : 0.1
 * @USING : SLINE LIB, DISCORD RPC LIB
 */
package hypronix.dev;

import com.sline.*;
import com.sline.setup.Setup;
import hypronix.dev.commands.Command;
import hypronix.dev.commands.CommandHandler;
import hypronix.dev.commands.presence;


public class Main {
    private static int bar = 1;
    private static int box = 1;
    public static void main(String[] args) throws Exception {
        presence.setup();
        presence.setLargeImage("term");
        presence.setDetails("<Terminal>");
        presence.setState(null);
        presence.reload();

        Sline.init(methods.variable);
        Setup.createFrame("HypronixTerminal", true, true);
        send.setup();
        Setup.setTextBar("", 45, bar);
        Setup.setImage("icon");
        Setup.setCheckBox("show console", box);
        Setup.setResizable(false);
        Setup.formatFrame();

        CommandHandler.register(new Command() {
            @Override
            public void onCall(String args) {
                Setup.createFrame("Discord Rich Presence modulator", true, false);
                Setup.setLabel("[desc], [title]", Setup.getGlobalPanel());
                Setup.setTextBar("desc", 10, 2);
                Setup.setTextBar("title", 10, 3);
                send.btn();
                Setup.formatFrame();
                Setup.setImage("icon");
                Setup.setResizable(false);
            }

            @Override
            public String getCallString() {
                return "rpc";
            }
        });

    }

    public static int getMainBar() {
        return bar;
    }
    public static int getMainBox() {
        return box;
    }

    public static void reloadCmd(){
        presence.setup();
        presence.setLargeImage("term");
        presence.setDetails("<Terminal>");
        presence.setState(null);
        presence.reload();
    }
}
