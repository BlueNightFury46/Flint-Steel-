package dev.bluenightfury46.flinatandsteelplus;

import dev.bluenightfury46.flinatandsteelplus.commands.flame;
import dev.bluenightfury46.flinatandsteelplus.commands.flinatandsteelplus;
import org.bukkit.plugin.java.JavaPlugin;

public final class flintandsteel extends JavaPlugin {

    public static flintandsteel plugin;

    public static double Cooldown;

    public static boolean useSoulFire;
    public static int radius;
    public static boolean isOnCooldown = false;

    public static int fireResistenceDuration;
    public static boolean giveFireResistence;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;
        flame.init();
        this.saveDefaultConfig();

        try{
            giveFireResistence = this.getConfig().getBoolean("give-fire-resistence");
            fireResistenceDuration = this.getConfig().getInt("fire-resistence-duration");
            Cooldown = this.getConfig().getDouble("cooldown");
            radius = this.getConfig().getInt("flame-radius")/2;
            useSoulFire = this.getConfig().getBoolean("soul-flame");
        } catch(NullPointerException e){
            giveFireResistence = true;
            fireResistenceDuration = 5;
            radius = 6/2;
            Cooldown = 0.5;
            useSoulFire = false;

            getLogger().warning("Warning! Failed to load config... Reverting to default config");
        }



        getServer().getPluginManager().registerEvents(new flinatandsteelplus(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
