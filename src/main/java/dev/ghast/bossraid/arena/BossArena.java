package dev.ghast.bossraid.arena;

import org.imanity.brew.game.Game;

public class BossArena extends Game {
    protected final BossArenaConfig config;

    public BossArena(BossArenaConfig config) {
        this.config = config;
    }

    public BossArenaConfig getConfig() {
        return config;
    }
}
