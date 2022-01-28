package com.julio.survivalcore.api;

import com.julio.survivalcore.SurvivalCore;
import org.bukkit.Bukkit;

public class Console {

    public static void send(String[] msg) {
        String cp = SurvivalCore.getConsolePrefix();
        for(int i=0;i < msg.length;i++) {
            msg[0] = cp+msg[0];
        }
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void send(String msg) {
        String cp = SurvivalCore.getConsolePrefix();
        Bukkit.getConsoleSender().sendMessage(cp+msg);
    }

}
