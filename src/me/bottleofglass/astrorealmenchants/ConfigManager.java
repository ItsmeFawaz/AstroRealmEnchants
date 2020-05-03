package me.bottleofglass.astrorealmenchants;

import org.bukkit.configuration.ConfigurationSection;

public class ConfigManager {
    private final ConfigurationSection ID1;
    private final ConfigurationSection ID2;
    private final ConfigurationSection ID3;
    private final ConfigurationSection ID4;
    private final ConfigurationSection ID5;
    private final ConfigurationSection ID6;
    private final ConfigurationSection ID7;
    private final ConfigurationSection ID8;
    private final ConfigurationSection ID9;
    private final ConfigurationSection ID10;
    private final ConfigurationSection ID11;
    private final ConfigurationSection ID12;
    private final ConfigurationSection ID13;
    private final ConfigurationSection ID14;
    private final ConfigurationSection ID15;
    private final ConfigurationSection ID16;
    private final ConfigurationSection ID17;
    private final ConfigurationSection ID18;
    private final ConfigurationSection ID19;
    public ConfigManager(Main main) {
        ID1 = main.getConfig().getConfigurationSection("enchants.ID1");
        ID2 = main.getConfig().getConfigurationSection("enchants.ID2");
        ID3 = main.getConfig().getConfigurationSection("enchants.ID3");
        ID4 = main.getConfig().getConfigurationSection("enchants.ID4");
        ID5 = main.getConfig().getConfigurationSection("enchants.ID5");
        ID6 = main.getConfig().getConfigurationSection("enchants.ID6");
        ID7 = main.getConfig().getConfigurationSection("enchants.ID7");
        ID8 = main.getConfig().getConfigurationSection("enchants.ID8");
        ID9 = main.getConfig().getConfigurationSection("enchants.ID9");
        ID10 = main.getConfig().getConfigurationSection("enchants.ID10");
        ID11 = main.getConfig().getConfigurationSection("enchants.ID11");
        ID12 = main.getConfig().getConfigurationSection("enchants.ID12");
        ID13 = main.getConfig().getConfigurationSection("enchants.ID13");
        ID14 = main.getConfig().getConfigurationSection("enchants.ID14");
        ID15 = main.getConfig().getConfigurationSection("enchants.ID15");
        ID16 = main.getConfig().getConfigurationSection("enchants.ID16");
        ID17 = main.getConfig().getConfigurationSection("enchants.ID17");
        ID18 = main.getConfig().getConfigurationSection("enchants.ID18");
        ID19 = main.getConfig().getConfigurationSection("enchants.ID19");
    }
    public ConfigurationSection getID1() {
        return ID1;
    }

    public ConfigurationSection getID2() {
        return ID2;
    }

    public ConfigurationSection getID3() {
        return ID3;
    }

    public ConfigurationSection getID4() {
        return ID4;
    }

    public ConfigurationSection getID5() {
        return ID5;
    }

    public ConfigurationSection getID6() {
        return ID6;
    }

    public ConfigurationSection getID7() {
        return ID7;
    }

    public ConfigurationSection getID8() {
        return ID8;
    }

    public ConfigurationSection getID9() {
        return ID9;
    }

    public ConfigurationSection getID10() {
        return ID10;
    }

    public ConfigurationSection getID11() {
        return ID11;
    }

    public ConfigurationSection getID12() {
        return ID12;
    }

    public ConfigurationSection getID13() {
        return ID13;
    }

    public ConfigurationSection getID14() {
        return ID14;
    }

    public ConfigurationSection getID15() {
        return ID15;
    }

    public ConfigurationSection getID16() {
        return ID16;
    }

    public ConfigurationSection getID17() {
        return ID17;
    }

    public ConfigurationSection getID18() {
        return ID18;
    }

    public ConfigurationSection getID19() {
        return ID19;
    }
}
