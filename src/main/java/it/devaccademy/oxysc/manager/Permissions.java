package it.devaccademy.oxysc.manager;

import org.bukkit.entity.Player;

public enum Permissions {

    COMMAND_MAIN("command.main"),
    STAFFCHAT("staffchat");

    private final String permission;

    Permissions(String permission) {
        this.permission = "oxysc." + permission;
    }

    public String getPermission() {
        return permission;
    }

    public boolean has(Player player) {
        return player.hasPermission(getPermission());
    }

}