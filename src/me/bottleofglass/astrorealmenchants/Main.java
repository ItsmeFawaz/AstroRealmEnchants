package me.bottleofglass.astrorealmenchants;

import me.bottleofglass.astrorealmenchants.commands.CEDisplayCommand;
import me.bottleofglass.astrorealmenchants.commands.CustomEnchantCommand;
import me.bottleofglass.astrorealmenchants.listeners.EnchantListener;
import me.bottleofglass.astrorealmenchants.listeners.EntityListener;
import me.bottleofglass.astrorealmenchants.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    private ConfigManager configManager;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        getCommand("ae").setExecutor(new CustomEnchantCommand());
        getCommand("ce").setExecutor(new CEDisplayCommand(configManager));
        Bukkit.getPluginManager().registerEvents(new EnchantListener(configManager), this);
        Bukkit.getPluginManager().registerEvents(new EntityListener(configManager), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
