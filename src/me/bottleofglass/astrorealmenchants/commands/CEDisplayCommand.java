package me.bottleofglass.astrorealmenchants.commands;

import me.bottleofglass.astrorealmenchants.ConfigManager;
import me.bottleofglass.astrorealmenchants.gui.CustomizedGUI;
import me.bottleofglass.astrorealmenchants.gui.GUI;
import me.bottleofglass.astrorealmenchants.gui.GUIButton;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CEDisplayCommand implements CommandExecutor {
    private CustomizedGUI gui;
    private ConfigManager configManager;
    public CEDisplayCommand(ConfigManager configManager) {
        this.configManager = configManager;
        gui = new CustomizedGUI(3);
        gui.addButton(0, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID1().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Has a " + configManager.getID1().getDouble("chanceToOccur") + "% chance to give enemy Wither effect."))));
        gui.addButton(1, new GUIButton(createStack(Material.DIAMOND_SWORD,"Sword",configManager.getID2().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Has a " + configManager.getID2().getDouble("chanceToOccur") + "% chance to give enemy Poison effect."))));
        gui.addButton(2, new GUIButton(createStack(Material.DIAMOND_SWORD,"Sword",configManager.getID3().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Has a " + configManager.getID3().getDouble("chanceToOccur") + "% chance to give enemy Slowness effect."))));
        gui.addButton(3, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID4().getString("name"), (ChatColor.BLUE + "&9Has a " + configManager.getID4().getDouble("chanceToOccur") + "% chance to give enemy"),
                (ChatColor.BLUE + "Nausea effect."))));
        gui.addButton(4, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID20().getString("name"), (ChatColor.BLUE + "&9Has a " + configManager.getID20().getDouble("chanceToOccur") + "% chance to give enemy"),
                (ChatColor.BLUE + "Hunger effect"))));
        gui.addButton(5, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID5().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Increases loot drop"))));
        gui.addButton(6, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID6().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Increases damage during night time by 13.3%"))));
        gui.addButton(7, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID7().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Increases damage during day time by 13.3%"))));
        gui.addButton(8, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID8().getString("name"), (ChatColor.BLUE +
                "Has a " + configManager.getID8().getDouble("chanceToOccur") + "% chance to heal self "),(ChatColor.BLUE + "by the amount of damage dealt."))));
        gui.addButton(9, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID21().getString("name"), (ChatColor.BLUE +
                "Has a " + configManager.getID21().getDouble("chanceToOccur") + "% chance to increase hunger "),(ChatColor.BLUE + "by 1/4 the amount of damage dealt."))));
        gui.addButton(10, new GUIButton(createStack(Material.DIAMOND_SWORD, "Sword",configManager.getID9().getString("name"), (ChatColor.BLUE +
                "Has a " + configManager.getID9().getDouble("chanceToOccur") + "% chance to instantly "),(ChatColor.BLUE + "kill the enemy"))));
        gui.addButton(11, new GUIButton(createStack(Material.DIAMOND_PICKAXE, "Pickaxe", configManager.getID23().getString("name"), (ChatColor.BLUE +
                "Instantly breaks obsidian blocks"))));
        gui.addButton(12, new GUIButton(createStack(Material.DIAMOND_PICKAXE, "Pickaxe", configManager.getID24().getString("name"), (ChatColor.BLUE +
                "Instantly breaks sponge blocks"))));
        gui.addButton(13, new GUIButton(createStack(Material.DIAMOND_HELMET, "Helmet", configManager.getID22().getString("name"), (ChatColor.BLUE +
                "Grants player permanent water breathing effect"))));
        gui.addButton(14, new GUIButton(createStack(Material.DIAMOND_HELMET, "Helmet",configManager.getID14().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Grants player permanent Night Vision effect"))));
        gui.addButton(15, new GUIButton(createStack(Material.DIAMOND_HELMET, "Helmet",configManager.getID15().getString("name"), (ChatColor.BLUE +
                "Saves player from death and restores "), (ChatColor.BLUE + "health to full and breaks itself in the process"))));
        gui.addButton(16, new GUIButton(createStack(Material.DIAMOND_HELMET, "Helmet",configManager.getID16().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Grants player permanent Saturation effect"))));
        gui.addButton(17, new GUIButton(createStack(Material.DIAMOND_CHESTPLATE, "Armor",configManager.getID10().getString("name"), (ChatColor.BLUE +
                "Takes effect if all armor piece has "),(ChatColor.BLUE + "this enchant, grants player Absorbtion III"))));
        gui.addButton(18, new GUIButton(createStack(Material.DIAMOND_CHESTPLATE, "Armor",configManager.getID19().getString("name"), (ChatColor.BLUE +
                "Increases max health by 1 heart for "),(ChatColor.BLUE + "each piece with this enchant"))));
        gui.addButton(19, new GUIButton(createStack(Material.DIAMOND_CHESTPLATE, "Armor",configManager.getID11().getString("name"), (ChatColor.BLUE +
                "Decreases damage by 9% for each armor"), (ChatColor.BLUE + "piece with this enchant"))));
        gui.addButton(20, new GUIButton(createStack(Material.DIAMOND_CHESTPLATE, "Chestplate",configManager.getID17().getString("name"), (ChatColor.BLUE +
                "Grants players Strength II and ") ,  (ChatColor.BLUE +"Slowness I"))));
        gui.addButton(21, new GUIButton(createStack(Material.DIAMOND_LEGGINGS, "Leggings",configManager.getID18().getString("name"), ChatColor.translateAlternateColorCodes('&',
                "&9Grants players Fire Resistance"))));
        gui.addButton(22, new GUIButton(createStack(Material.DIAMOND_BOOTS, "Boots",configManager.getID12().getString("name"), (ChatColor.BLUE + "Grants player permanent Jump Boost II"), (ChatColor.BLUE + "effect"))));
        gui.addButton(23, new GUIButton(createStack(Material.DIAMOND_BOOTS, "Boots",configManager.getID13().getString("name"), (ChatColor.BLUE +
                "Grants player permanent Speed II"),(ChatColor.BLUE +"effect"))));
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Only players make open the GUI!");
            return true;
        }
        Player player = (Player) commandSender;
        gui.open(player);
        return true;
    }
    public ItemStack createStack(Material material, String type,String name, String... description) {
        ItemStack returnStack = new ItemStack(material);
        ItemMeta meta = Bukkit.getItemFactory().getItemMeta(material);
        meta.setDisplayName(name);
        List<String> lores = new ArrayList<>();
        lores.add(" ");
        lores.add(ChatColor.GRAY + "Type: " + ChatColor.BLUE + type +" Enchantment.");
        lores.add(ChatColor.GRAY + "Max. Level: " + ChatColor.BLUE + "1.");
        lores.add(ChatColor.GRAY + "Effects:");
        lores.addAll(Arrays.asList(description));
        meta.setLore(lores);
        returnStack.setItemMeta(meta);
        return returnStack;
    }
}
