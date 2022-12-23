package it.devaccademy.oxysc.manager;

import java.util.ArrayList;
import java.util.UUID;

public class SCData {

    private static final ArrayList<UUID> scPlayers = new ArrayList<>();

    public static boolean isEnabled(UUID uuid) {
        return scPlayers.contains(uuid);
    }

    public static void remove(UUID uuid) {
        scPlayers.remove(uuid);
    }

    public static void add(UUID uuid) {
        scPlayers.add(uuid);
    }

}