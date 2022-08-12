package dev.ghast.bossraid.player;

import dev.ghast.bossraid.util.game.CachedInventory;
import io.fairyproject.mc.MCPlayer;
import io.fairyproject.metadata.MetadataKey;
import io.fairyproject.state.StateBase;
import org.bukkit.entity.Player;

public abstract class PlayerState extends StateBase implements PlayerListener {
    public static final MetadataKey<PlayerState> STATE_METADATA_KEY = MetadataKey.create("player_state", PlayerState.class);
    private final Player player;

    public PlayerState(Player player) {
        this.player = player;
    }

    @Override
    public void start() {
        if (isResetCharacter()) {
            CachedInventory.store(player);
            CachedInventory.reset(player);
        }

        super.start();
    }

    @Override
    public void end() {
        if (isResetCharacter()) {
            CachedInventory.reset(player);
            CachedInventory.restore(player);
        }

        super.end();
    }

    public boolean isResetCharacter() {
        return true;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public static PlayerState of(final Player player) {
        assert player != null : "Input player cannot be null";

        final MCPlayer mcPlayer = MCPlayer.from(player);

        assert mcPlayer.metadata().has(STATE_METADATA_KEY) : "Player does not uphold any state metadata";

        return mcPlayer.metadata().getOrNull(STATE_METADATA_KEY);
    }

    public static void store(PlayerState playerState) {
        assert playerState != null : "PlayerState specified cannot be null";
        assert playerState.getPlayer() != null : "PlayerState's player cannot be null";

        final MCPlayer mcPlayer = MCPlayer.from(playerState.getPlayer());
        mcPlayer.metadata().put(STATE_METADATA_KEY, playerState);
    }
}
