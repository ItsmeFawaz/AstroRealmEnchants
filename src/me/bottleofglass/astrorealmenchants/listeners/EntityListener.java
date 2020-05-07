package me.bottleofglass.astrorealmenchants.listeners;

import me.bottleofglass.astrorealmenchants.ConfigManager;
import me.bottleofglass.astrorealmenchants.Main;
import me.bottleofglass.astrorealmenchants.enchantapi.CustomEnchant;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class EntityListener implements Listener {
    private final ConfigManager configManager;
    public EntityListener(ConfigManager configManager) {
        this.configManager = configManager;
    }
    Random random = new Random();
    @EventHandler(ignoreCancelled = true,priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent evt) {
        if(evt.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK && evt.getDamager() != null && evt.getDamager() instanceof Player) {
            Player damager = (Player) evt.getDamager();
            CustomEnchant ench = CustomEnchant.getEnchant(damager.getItemInHand());
            if (ench != null && ench.getEquipment().equals("SWORD") && evt.getEntity() instanceof LivingEntity) {
                LivingEntity damaged = (LivingEntity) evt.getEntity();
                switch (ench.ordinal()) {
                    case 0:
                        if (random.nextInt(100) < configManager.getID1().getDouble("chanceToOccur")) {
                            new PotionEffect(PotionEffectType.WITHER, configManager.getID1().getInt("duration")*20, 1).apply((LivingEntity) evt.getEntity());
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 1:
                        if (random.nextInt(100) < configManager.getID2().getDouble("chanceToOccur")) {
                            new PotionEffect(PotionEffectType.POISON, configManager.getID2().getInt("duration")*20, 1).apply((LivingEntity) evt.getEntity());
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 2:
                        if (random.nextInt(100) < configManager.getID3().getDouble("chanceToOccur")) {
                            new PotionEffect(PotionEffectType.SLOW, configManager.getID3().getInt("duration")*20, 2).apply((LivingEntity) evt.getEntity());
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 3:
                        if (random.nextInt(100) < configManager.getID4().getDouble("chanceToOccur")) {
                            new PotionEffect(PotionEffectType.CONFUSION, configManager.getID4().getInt("duration")*20, 0).apply((LivingEntity) evt.getEntity());
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 4:
                        if(evt.getFinalDamage() >= ((LivingEntity) evt.getEntity()).getHealth()) {
                            ItemStack stack = damager.getItemInHand();
                            int looting = stack.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
                            stack.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
                            damager.setItemInHand(stack);
                            Bukkit.getScheduler().runTask(Main.getInstance(), () -> {
                                if (looting == 0) {
                                    stack.removeEnchantment(Enchantment.LOOT_BONUS_MOBS);
                                } else {
                                    stack.addEnchantment(Enchantment.LOOT_BONUS_MOBS, looting);
                                }
                                damager.setItemInHand(stack);
                            });
                        }
                        break;
                    case 5:
                        if (!isDay(damager.getWorld())) {
                            evt.setDamage(evt.getDamage() * 1.133D);
                        }
                        break;
                    case 6:
                        if (isDay(damager.getWorld())) {
                            evt.setDamage(evt.getDamage() * 1.133D);
                        }
                        break;
                    case 7:
                        if (random.nextInt(100) < configManager.getID8().getDouble("chanceToOccur")) {
                            damager.setHealth(Math.min(damager.getHealth() + evt.getFinalDamage(), damager.getMaxHealth()));
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 8:
                        if (random.nextInt(100) < configManager.getID9().getDouble("chanceToOccur")) {
                            damaged.setHealth(0);
                            damaged.sendMessage(ChatColor.RED + "You just got one shot by " + damager.getName()+ " using Death's Rose!");
                            damager.sendMessage(ChatColor.RED + "You got lucky and killed your opponent with one hit!");
                            damager.playSound(damager.getLocation(), Sound.FIZZ, 50, 30);
                        }
                        break;
                    case 19:
                        if (random.nextInt(100) < configManager.getID20().getDouble("chanceToOccur")) {
                            new PotionEffect(PotionEffectType.HUNGER, configManager.getID4().getInt("duration")*20, 0).apply((LivingEntity) evt.getEntity());
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    case 20:
                        if (random.nextInt(100) < configManager.getID20().getDouble("chanceToOccur")) {
                            damager.setFoodLevel(damager.getFoodLevel() + (int)Math.floor(evt.getFinalDamage()/4));
                            damager.playSound(damager.getLocation(), Sound.ORB_PICKUP, 50, 30);
                        }
                        break;
                    default:
                }
            }
        }
        if(evt.getEntity() instanceof Player) {
            Player damaged = (Player) evt.getEntity();
            if(damaged.getEquipment().getArmorContents().length != 0) {
                int marshmallowCount = 0;
                boolean halo = false;
                for(ItemStack armorPiece : damaged.getEquipment().getArmorContents()) {
                    CustomEnchant ench = CustomEnchant.getEnchant(armorPiece);
                    if(ench == CustomEnchant.ID11) {
                        marshmallowCount++;
                    } else if(ench == CustomEnchant.ID15) {
                        halo = true;
                    }
                }
                evt.setDamage(evt.getDamage() * (1-marshmallowCount*0.09D));
                if(halo && evt.getFinalDamage() >= damaged.getHealth()) {
                    damaged.setHealth(damaged.getMaxHealth());
                    damaged.playSound(damaged.getLocation(), Sound.ITEM_BREAK, 50, 50);
                    damaged.getEquipment().setHelmet(new ItemStack(Material.AIR));
                    damaged.sendMessage(ChatColor.GREEN + "Your Halo Helmet saved you, but it broke in process!");
                }
            }
        }

    }
    @EventHandler
    public void onClick(PlayerInteractEvent evt) {
        if(evt.getItem() == null)
            return;
        if(evt.getAction() == Action.RIGHT_CLICK_AIR || evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
            String armorType = evt.getItem().getType().toString().split("_").length == 2 ? evt.getItem().getType().toString().split("_")[1] : "";
            if((armorType.equalsIgnoreCase("helmet") && evt.getPlayer().getEquipment().getHelmet() == null) ||
                    (armorType.equalsIgnoreCase("chestplate") && evt.getPlayer().getEquipment().getChestplate() == null) ||
                    (armorType.equalsIgnoreCase("leggings") && evt.getPlayer().getEquipment().getLeggings() == null) ||
                    (armorType.equalsIgnoreCase("boots") && evt.getPlayer().getEquipment().getBoots() == null)) {
                Bukkit.getScheduler().runTask(Main.getInstance(), () -> {
                    CustomEnchant.updateEffects(evt.getPlayer());
                });
            }
        } else if(evt.getAction() == Action.LEFT_CLICK_BLOCK) {
            CustomEnchant ench = CustomEnchant.getEnchant(evt.getItem());
            if(ench == CustomEnchant.ID23 && evt.getClickedBlock().getType() == Material.OBSIDIAN) {
                evt.getClickedBlock().breakNaturally();
            } else if(ench == CustomEnchant.ID24 && evt.getClickedBlock().getType() == Material.SPONGE) {
                evt.getClickedBlock().breakNaturally();
            }
        }
    }
    public boolean isDay(World world) {
        long time = world.getTime() % 24000;

        return time < 12300 || time > 23850;
    }
}
