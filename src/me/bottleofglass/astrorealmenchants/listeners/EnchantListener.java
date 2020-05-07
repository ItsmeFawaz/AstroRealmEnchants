package me.bottleofglass.astrorealmenchants.listeners;

import me.bottleofglass.astrorealmenchants.ConfigManager;
import me.bottleofglass.astrorealmenchants.Main;
import me.bottleofglass.astrorealmenchants.enchantapi.CustomEnchant;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.EnchantingInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnchantListener implements Listener {
    private final Random random = new Random();
    private final ConfigManager configManager;

    public EnchantListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent evt) {
        if(CustomEnchant.getEnchant(evt.getItem()) != null) {
            return;
        }
        if(evt.getExpLevelCost() >= 30) {
            String equipment = evt.getItem().getType().toString().split("_").length == 2 ? evt.getItem().getType().toString().split("_")[1] : null;
            if(equipment != null) {
                if(random.nextInt(100) < Main.getInstance().getConfig().getInt("customEnchantChance")) {
                    List<CustomEnchant> enchants = new ArrayList<>();
                    if(equipment.equals("SWORD")) {
                        if (random.nextInt(100) < configManager.getID1().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID1);
                        if (random.nextInt(100) < configManager.getID2().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID2);
                        if (random.nextInt(100) < configManager.getID3().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID3);
                        if (random.nextInt(100) < configManager.getID4().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID4);
                        if (random.nextInt(100) < configManager.getID5().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID5);
                        if (random.nextInt(100) < configManager.getID6().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID6);
                        if (random.nextInt(100) < configManager.getID7().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID7);
                        if (random.nextInt(100) < configManager.getID8().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID8);
                        if (random.nextInt(100) < configManager.getID9().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID9);
                    } else if(equipment.equals("HELMET")) {
                        if (random.nextInt(100) < configManager.getID10().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID10);
                        if (random.nextInt(100) < configManager.getID19().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID19);
                        if (random.nextInt(100) < configManager.getID11().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID11);
                        if (random.nextInt(100) < configManager.getID14().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID14);
                        if (random.nextInt(100) < configManager.getID15().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID15);
                        if (random.nextInt(100) < configManager.getID16().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID16);
                    } else if(equipment.equals("CHESPLATE")) {
                        if (random.nextInt(100) < configManager.getID10().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID10);
                        if (random.nextInt(100) < configManager.getID19().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID19);
                        if (random.nextInt(100) < configManager.getID11().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID11);
                        if (random.nextInt(100) < configManager.getID17().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID17);
                    } else if(equipment.equals("LEGGINGS")) {
                        if (random.nextInt(100) < configManager.getID10().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID10);
                        if (random.nextInt(100) < configManager.getID19().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID19);
                        if (random.nextInt(100) < configManager.getID11().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID11);
                        if (random.nextInt(100) < configManager.getID18().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID18);
                    } else if(equipment.equals("BOOTS")) {
                        if (random.nextInt(100) < configManager.getID10().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID10);
                        if (random.nextInt(100) < configManager.getID19().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID19);
                        if (random.nextInt(100) < configManager.getID11().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID11);
                        if (random.nextInt(100) < configManager.getID12().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID12);
                        if (random.nextInt(100) < configManager.getID13().getDouble("chanceToGet"))
                            enchants.add(CustomEnchant.ID13);
                    }
                    CustomEnchant enchToAdd;
                    if(enchants.size() != 0) {
                        enchToAdd = enchants.get(random.nextInt(enchants.size()));
                        Bukkit.getScheduler().runTask(Main.getInstance(), () -> {
                            ((EnchantingInventory) evt.getInventory()).setItem(enchToAdd.putEnchant(evt.getItem()));
                        });
                    }

                }
            }
        }
    }
}
