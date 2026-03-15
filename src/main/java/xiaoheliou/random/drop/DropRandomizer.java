package xiaoheliou.random.drop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;
import xiaoheliou.random.util.RandomPool;

public final class DropRandomizer
implements Listener {
    public DropRandomizer(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, plugin);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.isCancelled()) {
            return;
        }
        e.setDropItems(false);
        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), RandomPool.randomItem());
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        e.getDrops().clear();
        e.getDrops().add(RandomPool.randomItem());
    }
}

