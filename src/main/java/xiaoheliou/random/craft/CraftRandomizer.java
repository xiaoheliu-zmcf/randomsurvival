package xiaoheliou.random.craft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.plugin.Plugin;
import xiaoheliou.random.util.RandomPool;

public final class CraftRandomizer
implements Listener {
    public CraftRandomizer(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, plugin);
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.isCancelled()) {
            return;
        }
        e.setCurrentItem(RandomPool.randomItem());
    }
}

