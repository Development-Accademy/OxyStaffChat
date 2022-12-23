package it.devaccademy.oxysc.provider;

import it.devaccademy.oxysc.SCBukkit;
import it.devaccademy.oxysc.commands.main.MainCommand;
import it.devaccademy.oxysc.commands.staffchat.StaffChatCommand;
import it.devaccademy.oxysc.listeners.ChatListener;
import org.bukkit.plugin.PluginManager;

public class OxySCDataProvider {

    private final SCBukkit plugin;

    public OxySCDataProvider(SCBukkit plugin) {
        this.plugin = plugin;
        registerListeners();
        registerCommands();
    }

    public void registerListeners() {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new ChatListener(plugin), plugin);
    }

    public void registerCommands() {
        new MainCommand(plugin);
        new StaffChatCommand(plugin);
    }

}