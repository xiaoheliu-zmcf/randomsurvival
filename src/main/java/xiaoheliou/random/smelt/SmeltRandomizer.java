package xiaoheliou.random.smelt;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.plugin.Plugin;
import xiaoheliou.random.util.RandomPool;

public final class SmeltRandomizer
implements Listener {
    public SmeltRandomizer(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, plugin);
    }

    @EventHandler
    public void onSmelt(FurnaceSmeltEvent e) {
        if (e.isCancelled()) {
            return;
        }
        e.setResult(RandomPool.randomItem());
    }
}

