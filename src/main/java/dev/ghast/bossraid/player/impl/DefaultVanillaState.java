package dev.ghast.bossraid.player.impl;

import dev.ghast.bossraid.player.PlayerState;
import org.bukkit.entity.Player;

public class DefaultVanillaState extends PlayerState {
    public DefaultVanillaState(Player player) {
        super(player);
    }

    @Override
    protected void onStart() {
        // Empty
    }

    @Override
    protected void onUpdate() {
        // Empty
    }

    @Override
    protected void onEnded() {
        // Empty
    }

    @Override
    public boolean isResetCharacter() {
        return false;
    }
}
