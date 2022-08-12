package dev.ghast.bossraid.player.impl.editor;

import dev.ghast.bossraid.arena.BossArena;
import dev.ghast.bossraid.player.PlayerState;
import org.bukkit.entity.Player;

public abstract class PlayerGameState extends PlayerState {
    protected final BossArena arena;

    public PlayerGameState(Player player, BossArena arena) {
        super(player);
        this.arena = arena;
    }
}
