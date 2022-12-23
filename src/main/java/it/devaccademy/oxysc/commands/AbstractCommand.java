package it.devaccademy.oxysc.commands;

import it.devaccademy.oxysc.SCBukkit;
import it.devaccademy.oxysc.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CommandExecutor {

    protected String command, permission;
    protected boolean canConsoleUse;
    protected SCBukkit plugin = SCBukkit.getInstance();

    public AbstractCommand(String command, String permission, boolean canConsoleUse) {
        this.command = command;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;

        plugin.getCommand(command).setExecutor(this);
    }

    public void sendMessage(CommandSender sender, String message) {
        if(!(sender instanceof Player)) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatUtils.color(message));
            return;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatUtils.color(message));
    }

    public abstract void execute(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = plugin.getConfig();

        if(!canConsoleUse && !(sender instanceof Player)) {
            sendMessage(sender, config.getString("messages.no_console"));
            return true;
        }

        if(permission != null && !sender.hasPermission(permission)) {
            Player player = (Player) sender;
            sendMessage(player, config.getString("messages.insufficient_permissions"));
            return true;
        }

        execute(sender, args);
        return true;
    }

}