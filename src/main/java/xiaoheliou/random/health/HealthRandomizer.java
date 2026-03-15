package xiaoheliou.random.health;

import java.util.Random;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import xiaoheliou.random.XhRandomPlugin;

public final class HealthRandomizer
implements Listener {
    private static final Random RAND = new Random();
    private static final int MIN = 6;
    private static final int MAX = 40;

    public HealthRandomizer(XhRandomPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        HealthRandomizer.apply(e.getPlayer());
    }

    public static void apply(Player p) {
        int hp = 6 + RAND.nextInt(35);
        p.getAttribute(Attribute.MAX_HEALTH).setBaseValue((double)hp);
        p.setHealth((double)hp);
    }

    public static void reset(Player p) {
        HealthRandomizer.apply(p);
    }
}

