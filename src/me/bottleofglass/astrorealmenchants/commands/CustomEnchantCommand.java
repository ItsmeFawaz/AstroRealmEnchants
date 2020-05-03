package me.bottleofglass.astrorealmenchants.commands;

import io.netty.util.internal.StringUtil;
import me.bottleofglass.astrorealmenchants.enchantapi.CustomEnchant;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "You can't execute this from console!");
            return true;
        }
        Player player = (Player) commandSender;
        if(strings.length < 1) {
            return false;
        }
        String arg = String.join(" ", strings);
        CustomEnchant enchant = CustomEnchant.getByName(arg);
        if(enchant == null) {
            if(NumberUtils.isDigits(arg)) {
                enchant = CustomEnchant.getByID(Integer.parseInt(arg));
            }
        }
        if(enchant == null) {
            player.sendMessage(ChatColor.RED + "Invalid enchantment name/id");
            return true;
        }
        ItemStack itemInHand = player.getItemInHand();
        if(itemInHand != null) {
            if(CustomEnchant.getEnchant(itemInHand) != null) {
                player.sendMessage(ChatColor.RED + "Item already has a custom enchant!");
                return true;
            }
            String equipment = itemInHand.getType().toString().split("_").length == 2? player.getItemInHand().getType().toString().split("_")[1] : null;
            if(equipment != null && ((enchant.getEquipment().equals("ARMOR") && (equipment.equals("HELMET") || equipment.equals("CHESTPLATE") || equipment.equals("LEGGINGS") || equipment.equals("BOOTS"))) || (enchant.getEquipment().equals(equipment)))) {
                enchant.putEnchant(itemInHand);
                player.setItemInHand(itemInHand);
            } else {
                player.sendMessage(ChatColor.RED + "You cannot put " + ChatColor.AQUA + enchant.getName() + ChatColor.RED +" on a " + ChatColor.YELLOW + equipment);
            }
        }
        return true;
    }
}
