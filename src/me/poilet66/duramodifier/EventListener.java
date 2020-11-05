package me.poilet66.duramodifier;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventListener implements Listener {

    private final Plugin main;
    private final List<Material> diamond = new ArrayList<>(Arrays.asList(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS));
    private final List<Material> other = new ArrayList<>(Arrays.asList(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_BOOTS,
            Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS,
            Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS,
            Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS));

    public EventListener(Plugin main) {
        this.main = main;
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();
        if(other.contains(item.getType()) || diamond.contains(item.getType())) {
            //event.getPlayer().sendMessage("Your " + item.getItemMeta().getDisplayName() + " took " + event.getDamage() + " damage");
            int damageToSet = 1;
            int unbLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
            if (other.contains(item.getType())) {
                if (unbLevel == 1) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 10) {
                        damageToSet = 0;
                    }
                } else if (unbLevel == 2) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 20) {
                        damageToSet = 0;
                    }
                } else if (unbLevel == 3) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 30) {
                        damageToSet = 0;
                    }
                } else {
                    damageToSet = 1;
                }
            } else if (other.contains(item.getType())) {
                if (unbLevel == 1) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 5) {
                        damageToSet = 0;
                    }
                } else if (unbLevel == 2) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 10) {
                        damageToSet = 0;
                    }
                } else if (unbLevel == 3) {
                    if (getRandomIntegerBetweenRange(1, 100) <= 15) {
                        damageToSet = 0;
                    }
                } else {
                    damageToSet = 1;
                }
            }
            //event.getPlayer().sendMessage("Your " + item.getItemMeta().getDisplayName() + " ended up taking " + damageToSet + " damage");
            event.setDamage(damageToSet);
        }
    }

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
