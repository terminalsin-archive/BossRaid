package dev.ghast.bossraid.util.game;

import io.fairyproject.mc.MCPlayer;
import io.fairyproject.metadata.MetadataKey;
import lombok.Builder;
import lombok.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

@Data
@Builder
public class CachedInventory {
    public static final MetadataKey<CachedInventory> CACHED_INVENTORY_METADATA_KEY = MetadataKey.create("cache_inventory", CachedInventory.class);
    private ItemStack[] items;
    private int experience;
    private float exhaustion;
    private double health;
    private float flySpeed;
    private float walkSpeed;
    private boolean allowFlight;
    private boolean flying;
    private GameMode gameMode;

    public static void store(final Player player) {
        assert player != null : "Player object cannot be null";

        final MCPlayer mcPlayer = MCPlayer.find(player.getUniqueId());

        assert mcPlayer != null : "Minecraft player counterpart cannot be null";

        mcPlayer.metadata().put(
                CACHED_INVENTORY_METADATA_KEY,
                CachedInventory.of(player)
        );
    }

    public static void restore(final Player player) {
        assert player != null : "Player object cannot be null";

        final MCPlayer mcPlayer = MCPlayer.find(player.getUniqueId());

        assert mcPlayer != null
                : "Minecraft player counterpart cannot be null";
        assert mcPlayer.metadata() != null
                : "Player metadata cannot be null";
        assert mcPlayer.metadata().has(CACHED_INVENTORY_METADATA_KEY)
                : "Metadata map must contain a cached inventory";

        mcPlayer.metadata().get(
                CACHED_INVENTORY_METADATA_KEY
        ).get().use(player);
    }

    public static void reset(final Player player) {
        assert player != null : "Player object cannot be null";

        player.getInventory().clear();
        player.setTotalExperience(0);
        //player.setWalkSpeed(0.4F);
        //player.setFlySpeed(0.4F);
        player.setFlying(false);
        player.setAllowFlight(false);
    }

    public static CachedInventory of(final Player player) {
        final ItemStack[] items = Arrays.copyOf(
                player.getInventory().getContents(),
                player.getInventory().getContents().length
        );

       return new CachedInventoryBuilder()
                .items(items)
                .experience(player.getTotalExperience())
                .exhaustion(player.getExhaustion())
                .health(player.getHealth())
                .flySpeed(player.getFlySpeed())
                .walkSpeed(player.getWalkSpeed())
                .allowFlight(player.getAllowFlight())
                .flying(player.isFlying())
                .gameMode(player.getGameMode())
                .build();
    }

    public void use(final Player player) {
        player.getInventory().setContents(items);
        player.setTotalExperience(experience);
        player.setExhaustion(exhaustion);
        player.setHealth(health);
        player.setFlySpeed(flySpeed);
        player.setWalkSpeed(walkSpeed);
        player.setAllowFlight(allowFlight);
        player.setFlying(flying);
        player.setGameMode(gameMode);
    }
}
