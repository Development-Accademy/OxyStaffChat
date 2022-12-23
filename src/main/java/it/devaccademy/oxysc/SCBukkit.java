package it.devaccademy.oxysc;

import it.devaccademy.oxysc.provider.OxySCDataProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class SCBukkit extends JavaPlugin {

    private static SCBukkit instance;
    private OxySCDataProvider provider;

    public static SCBukkit getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        provider = new OxySCDataProvider(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
