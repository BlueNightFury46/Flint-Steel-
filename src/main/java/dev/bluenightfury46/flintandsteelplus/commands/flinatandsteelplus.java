package dev.bluenightfury46.flintandsteelplus.commands;

import dev.bluenightfury46.flintandsteelplus.flintandsteel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class  flinatandsteelplus implements Listener {
    @EventHandler

    public void event(PlayerInteractEvent e) {

        try {

            if (!flintandsteel.isOnCooldown) {

                if (e.getAction().isRightClick() && e.getItem().equals(flame.FLINT_AND_STEEL_PLUS)) {


                    Location loc = e.getClickedBlock().getLocation();
                    Location pos1 = new Location(loc.getWorld(), loc.x() - flintandsteel.radius, loc.y(), loc.z() - flintandsteel.radius);
                    Location pos2 = new Location(loc.getWorld(), loc.x() + flintandsteel.radius, loc.y(), loc.z() + flintandsteel.radius);
                    double x_difference = pos2.x() - pos1.x();
                    double z_difference = pos2.z() - pos1.z();

                    for (int x = (int) pos1.x(); x < (int) pos2.x(); x++) {



                        for (int z = (int) pos1.z(); z < (int) pos2.z(); z++) {
                            double ypos = loc.getWorld().getHighestBlockAt(x, z).getLocation().y();
                            if ((ypos - e.getClickedBlock().getLocation().x()) <= 3) {
                                Location finalLoc = new Location(loc.getWorld(), x, ypos + 1, z);
                                if (flintandsteel.useSoulFire) {
                                    new Location(loc.getWorld(), x, ypos, z).getBlock().setType(Material.SOUL_SAND);
                                    finalLoc.getBlock().setType(Material.SOUL_FIRE);
                                } else {
                                    finalLoc.getBlock().setType(Material.FIRE);
                                }
                            }

                        }


                    }
                    if(flintandsteel.giveFireResistence) {
                        PotionEffect p = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (flintandsteel.fireResistenceDuration*20), 1);
                        e.getPlayer().addPotionEffect(p);
                    }
                    flintandsteel.isOnCooldown = true;


                    Bukkit.getScheduler().runTaskLater(flintandsteel.plugin, () -> {
                        flintandsteel.isOnCooldown = false;}, (long)(flintandsteel.Cooldown*20));


                }


            } else {
               if(e.getClickedBlock().getType().equals(Material.FIRE)){
                   e.getClickedBlock().setType(Material.AIR);
               }
            }
            } catch(NullPointerException ex){

            }

    }




}
