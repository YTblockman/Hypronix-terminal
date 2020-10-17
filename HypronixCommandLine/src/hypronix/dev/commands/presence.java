package hypronix.dev.commands;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class presence {

    private static DiscordRichPresence presence;
    private static DiscordRPC lib;

    public static void setup(){
        lib = DiscordRPC.INSTANCE;
        String applicationId = "766707321602048061";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();

        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        System.out.println("[hypronix term] = regenerating presence");
        presence.details = "Typing command! :)";
        if(cmd.getCmd() == null)
            presence.state = "didn't ran any program...";
        else
            presence.state = "Last ran: " + cmd.getCmd();
        presence.largeImageKey = "icon";
        lib.Discord_UpdatePresence(presence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }

    public static void reload(){
        lib.Discord_UpdatePresence(presence);
    }
    public static void setState(String state){
        String def = "Last ran: " + cmd.getCmd();
        if(cmd.getCmd() != null){
            def = "Last ran: " + cmd.getCmd();
        }else
            def = "Didn't run any program";
        if(state == null){
            presence.state = def;
            return;
        }
        presence.state = state;
    }

    public static void setLargeImage(String image){
        presence.largeImageKey = image;
    }

    public static void setDetails(String details){
        presence.details = details;
    }
}
