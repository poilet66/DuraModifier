package me.poilet66.duramodifier;

import org.bukkit.plugin.java.JavaPlugin;

public class DuraModifier extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getLogger().info("Enabled.");
    }

    public void onDisable() {
        getLogger().info("Disabled.");
    }
}
