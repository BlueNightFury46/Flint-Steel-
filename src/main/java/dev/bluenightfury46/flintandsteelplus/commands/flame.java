package dev.bluenightfury46.flintandsteelplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class flame {

   public static ItemStack FLINT_AND_STEEL_PLUS;

   public static void init(){

       FLINT_AND_STEEL_PLUS = new ItemStack(Material.FLINT_AND_STEEL);

       ItemMeta meta = FLINT_AND_STEEL_PLUS.getItemMeta();

       meta.setItemName(ChatColor.GOLD + "Flint and Steel+");

       meta.setUnbreakable(true);
       FLINT_AND_STEEL_PLUS.setItemMeta(meta);

       ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("flint_and_steel_plus"), FLINT_AND_STEEL_PLUS);

       recipe.addIngredient(Material.IRON_BLOCK);
       recipe.addIngredient(Material.FLINT);
       Bukkit.getServer().addRecipe(recipe);


   }


}
