package it.devaccademy.oxysc.commands.staffchat;

import it.devaccademy.oxysc.SCBukkit;
import it.devaccademy.oxysc.commands.AbstractCommand;
import it.devaccademy.oxysc.manager.Permissions;
import it.devaccademy.oxysc.manager.SCData;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class StaffChatCommand extends AbstractCommand {

    private final SCBukkit plugin;

    public StaffChatCommand(SCBukkit plugin) {
        super("staffchat", Permissions.STAFFCHAT.getPermission(), false);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        FileConfiguration config = plugin.getConfig();
        Player player = (Player) sender;

        if (!SCData.isEnabled(player.getUniqueId())) {
            SCData.add(player.getUniqueId());
            sendMessage(player, config.getString("messages.sc_enabled"));
            return;
        }

        SCData.remove(player.getUniqueId());
        sendMessage(player, config.getString("messages.sc_disabled"));
    }

}