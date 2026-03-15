package xiaoheliou.random.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class RandomPool {
    private static final List<Material> POOL = new ArrayList<Material>();
    private static final Random RAND = new Random();

    public static ItemStack randomItem() {
        Material m = POOL.get(RAND.nextInt(POOL.size()));
        return new ItemStack(m);
    }

    static {
        for (Material m : Material.values()) {
            if (!m.isItem()) continue;
            POOL.add(m);
        }
    }
}

