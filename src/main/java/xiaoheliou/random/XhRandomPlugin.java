package xiaoheliou.random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xiaoheliou.random.craft.CraftRandomizer;
import xiaoheliou.random.drop.DropRandomizer;
import xiaoheliou.random.health.HealthRandomizer;
import xiaoheliou.random.smelt.SmeltRandomizer;

public final class XhRandomPlugin
extends JavaPlugin
implements Listener {
    
    public void onEnable() {
        this.saveDefaultConfig();
        new DropRandomizer((Plugin)this);
        new CraftRandomizer((Plugin)this);
        new SmeltRandomizer((Plugin)this);
        new HealthRandomizer(this);
        
        getServer().getPluginManager().registerEvents(this, this);
        
        this.getCommand("xh").setExecutor((sender, cmd, label, args) -> {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§c玩家才能使用");
                return true;
            }
            Player p = (Player)sender;
            HealthRandomizer.reset(p);
            sender.sendMessage("§a血量已重置为随机值！");
            return true;
        });
        this.getLogger().info("XhRandom 已加载 —— 挖掘、击杀、合成、烧炼、血量 全部随机！");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            player.sendMessage("§a欢迎使用Random插件!!!");
        }
    }
}
