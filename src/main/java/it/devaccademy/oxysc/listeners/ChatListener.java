package it.devaccademy.oxysc.listeners;

import it.devaccademy.oxysc.SCBukkit;
import it.devaccademy.oxysc.manager.Permissions;
import it.devaccademy.oxysc.manager.SCData;
import it.devaccademy.oxysc.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final SCBukkit plugin;

    public ChatListener(SCBukkit plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        FileConfiguration config = plugin.getConfig();
        Player player = event.getPlayer();

        if(!SCData.isEnabled(player.getUniqueId())) return;

        if(!Permissions.STAFFCHAT.has(player)) {
            SCData.remove(player.getUniqueId());
            return;
        }

        event.setCancelled(true);

        for(Player staff : Bukkit.getOnlinePlayers()) {
            if(!staff.hasPermission(Permissions.STAFFCHAT.getPermission())) return;

            String format = config.getString("format")
                    .replace("%player%", player.getName())
                    .replace("%message%", event.getMessage());

            staff.sendMessage(ChatUtils.color(format));
        }

    }

}