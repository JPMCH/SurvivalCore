package com.julio.survivalcore.api;

import com.julio.survivalcore.SurvivalCore;
import org.bukkit.Bukkit;

import java.util.Locale;

public class Console {



    public static void send(String[] msg) {
        String cp = SurvivalCore.getConsolePrefix();
        for(int i=0;i < msg.length;i++) {
            msg[i] = cp+msg[i];
        }
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void send(String msg) {
        String cp = SurvivalCore.getConsolePrefix();
        Bukkit.getConsoleSender().sendMessage(cp+msg);
    }

    public static void nodeInfo(String[] msg, String node) {
        String cp = SurvivalCore.getConsoleNodePrefix()
                .replace("%node%",""+node.toUpperCase());
        for(int i=0;i < msg.length;i++) {
            msg[i] = cp+msg[i];
        }
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void nodeInfo(String msg, String node) {
        String cp = SurvivalCore.getConsoleNodePrefix()
                .replace("%node%",""+node.toUpperCase());
        msg = cp+msg;
        Bukkit.getConsoleSender().sendMessage(msg);
    }

}
