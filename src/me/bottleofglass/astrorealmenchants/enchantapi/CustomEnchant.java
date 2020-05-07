package me.bottleofglass.astrorealmenchants.enchantapi;

import me.bottleofglass.astrorealmenchants.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum CustomEnchant {
    ID1(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID1().getString("name")),"SWORD"),
    ID2(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID2().getString("name")),"SWORD"),
    ID3(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID3().getString("name")),"SWORD"),
    ID4(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID4().getString("name")),"SWORD"),
    ID5(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID5().getString("name")),"SWORD"),
    ID6(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID6().getString("name")),"SWORD"),
    ID7(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID7().getString("name")),"SWORD"),
    ID8(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID8().getString("name")),"SWORD"),
    ID9(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID9().getString("name")),"SWORD"),
    ID10(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID10().getString("name")),"ARMOR"),
    ID11(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID11().getString("name")),"ARMOR"),
    ID12(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID12().getString("name")),"BOOTS"),
    ID13(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID13().getString("name")),"BOOTS"),
    ID14(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID14().getString("name")),"HELMET"),
    ID15(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID15().getString("name")),"HELMET"),
    ID16(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID16().getString("name")),"HELMET"),
    ID17(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID17().getString("name")),"CHESTPLATE"),
    ID18(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID18().getString("name")),"LEGGINGS"),
    ID19(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID19().getString("name")), "ARMOR"),
    ID20(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID20().getString("name")), "SWORD"),
    ID21(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID21().getString("name")), "SWORD"),
    ID22(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID22().getString("name")), "HELMET"),
    ID23(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID23().getString("name")), "PICKAXE"),
    ID24(ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfigManager().getID24().getString("name")), "PICKAXE");
    private final String name;
    private final String equipment;
    CustomEnchant(String name, String equipment) {
        this.name = name;
        this.equipment = equipment;
    }
    public ItemStack putEnchant(ItemStack stack) {
        if(stack != null) {
            ItemMeta meta;
            if(stack.hasItemMeta()) {
                meta = stack.getItemMeta();
            } else {
                meta = Bukkit.getItemFactory().getItemMeta(stack.getType());
            }

            List<String> lores;
            if(stack.getItemMeta().hasLore()) {
                lores = meta.getLore();
            } else {
                lores = new ArrayList<>();
            }
            lores.add(this.getName());
            meta.setLore(lores);
            stack.setItemMeta(meta);
        }
        return stack;
    }
    public static void updateEffects(LivingEntity entity) {
        int brothersGuardCount = 0;
        int godsdiscipleCount = 0;
        List<PotionEffect> toAdd = new ArrayList<>();
        for (ItemStack armorPiece : entity.getEquipment().getArmorContents()) {
            CustomEnchant ench = getEnchant(armorPiece);
            if(ench == null)
                continue;
            if (ench == CustomEnchant.ID10) {
                brothersGuardCount++;
            } else if (ench == CustomEnchant.ID12) {
                toAdd.add(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
            } else if (ench == CustomEnchant.ID13) {
                toAdd.add(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            } else if (ench == CustomEnchant.ID14) {
                toAdd.add(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
            } else if(ench == CustomEnchant.ID16) {
                toAdd.add(new PotionEffect(PotionEffectType.SATURATION, 99999999, 0));
            }else if(ench == CustomEnchant.ID17) {
                toAdd.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                toAdd.add(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
            } else if(ench == CustomEnchant.ID18) {
                toAdd.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
            } else if(ench == CustomEnchant.ID19) {
                godsdiscipleCount++;
            } else if(ench == CustomEnchant.ID22) {
                toAdd.add(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
            }
        }
        if(brothersGuardCount >= 4) {
            toAdd.add(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 2));
        }

        entity.setMaxHealth(20 + (2*godsdiscipleCount));
        for(PotionEffect effect : entity.getActivePotionEffects()) {
            if(effect.getDuration() > 1000000 && !toAdd.contains(effect)) {
                entity.removePotionEffect(effect.getType());
            }
        }
        for(PotionEffect effect : toAdd) {
            entity.addPotionEffect(effect, true);
        }

    }
    public static CustomEnchant getEnchant(ItemStack stack) {
        if(stack.hasItemMeta() && stack.getItemMeta().hasLore()) {
            for(String lore : stack.getItemMeta().getLore()) {
                if(getByName(lore) != null) {
                    return getByName(lore);
                }
            }
        }
        return null;
    }
    public static CustomEnchant getByName(String name) {
        Optional<CustomEnchant> enchant = Arrays.stream(CustomEnchant.values()).filter(x -> x.getName().equalsIgnoreCase(ChatColor.stripColor(name))).findFirst();
        if(enchant.isPresent()) {
            return enchant.get();
        }
        return null;
    }
    public static CustomEnchant getByID(int id) {
        return CustomEnchant.valueOf("ID" + id);
    }
    public static void enchant(ItemStack stack) {
    }
    public String getName() {
        return name;
    }

    public String getEquipment() {
        return equipment;
    }
}
