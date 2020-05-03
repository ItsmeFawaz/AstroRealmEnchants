package me.bottleofglass.astrorealmenchants.listeners;

import me.bottleofglass.astrorealmenchants.Main;
import me.bottleofglass.astrorealmenchants.enchantapi.CustomEnchant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent evt) {
        if(evt.getClickedInventory() == null || evt.getInventory() == null) {
            return;
        }
        if((evt.getCurrentItem() != null && CustomEnchant.getEnchant(evt.getCurrentItem()) != null) ||
                (evt.getCursor() != null && CustomEnchant.getEnchant(evt.getCursor()) != null) ||
                (evt.getHotbarButton() != -1 && evt.getWhoClicked().getInventory().getItem(evt.getHotbarButton()) != null && CustomEnchant.getEnchant(evt.getWhoClicked().getInventory().getItem(evt.getHotbarButton()))!= null)) {
            Bukkit.getScheduler().runTask(Main.getInstance(), () -> CustomEnchant.updateEffects((Player) evt.getWhoClicked()));
        }
    }
}
