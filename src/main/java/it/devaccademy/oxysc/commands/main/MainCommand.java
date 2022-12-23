package it.devaccademy.oxysc.commands.main;

import it.devaccademy.oxysc.SCBukkit;
import it.devaccademy.oxysc.commands.AbstractCommand;
import it.devaccademy.oxysc.manager.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class MainCommand extends AbstractCommand {

    private final SCBukkit plugin;

    public MainCommand(SCBukkit plugin) {
        super("oxystaffchat", Permissions.COMMAND_MAIN.getPermission(), true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        FileConfiguration config = plugin.getConfig();

        if (args.length != 1) {
            sendMessage(sender, "&9• &7Running &3Oxy&9StaffChat &7version &b" + plugin.getDescription().getVersion());
            sendMessage(sender, "&7  Created by &9Development Accademy &f(Axiid)");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();

            sendMessage(sender, config.getString("messages.plugin_reloaded"));
            return;
        }

        sendMessage(sender, config.getString("messages.invalid_arguments"));
    }

}