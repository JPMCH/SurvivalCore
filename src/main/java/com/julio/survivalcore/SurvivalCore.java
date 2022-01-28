package com.julio.survivalcore;

import com.julio.survivalcore.api.Console;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class SurvivalCore extends JavaPlugin {

    private static final Random random = new Random();
    private static final String consolePrefix = "§8[§a§lSERVER§8]§f ";
    private static final String consoleNodePrefix = "§8[§a§lSERVER-%node%§8]§f ";
    private static int updateCooldown;

    public String flag;

    public static SurvivalCore instance;

    @Override
    public void onEnable() {
        setInstance();
        onStarted();
        startConfig();

        // flag system
        updateCooldown = 50;
        flagAutomaticUpdate(updateCooldown - 1);
        //
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    // SYSTEM IMPORTANT OPERATIONS

    public void flagAutomaticUpdate(int seconds) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(instance,() -> {
            String flagBody = "FLAG-";
            flag = flagBody+""+random.nextFloat(5000);
            Console.send("new Flag! ("+flag+")");
        }, 20L *seconds, 20L *seconds);
    }

    public void setInstance() {
        instance = this;
    }

    public void startConfig() {
        this.getConfig().options().copyDefaults(false);
        this.saveDefaultConfig();
    }

    //

    // SYSTEM NOTIFICATIONS
    public void onStarted() {
        ConsoleCommandSender ccm = Bukkit.getConsoleSender();
        String[] startupMSGs = new String[3];
        startupMSGs[0] = ChatColor.BLUE + "[SurvivalCore] initializing...";
        startupMSGs[1] = ChatColor.YELLOW + "       * Loading Resources";
        startupMSGs[2] = ChatColor.YELLOW + "       * Version: "+this;
        Console.send(startupMSGs);
    }
    //


    public static int getUpdateCooldown() {
        return updateCooldown;
    }

    public static SurvivalCore getInstance() {
        return instance;
    }

    public String getFlag() {
        return flag;
    }

    public static String getConsolePrefix() {
        return consolePrefix;
    }

    public static String getConsoleNodePrefix() {
        return consoleNodePrefix;
    }

    public static Random getRandom() {
        return random;
    }
}
