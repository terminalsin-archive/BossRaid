package dev.ghast.bossraid.arena;

import org.imanity.brew.game.Game;
import org.imanity.brew.game.state.GameStateBase;

public abstract class BossArenaState extends GameStateBase {
    public BossArenaState(BossArena parent) {
        super(parent);
    }

    public String getGameName() {
        return this.getGame().getConfig().getName();
    }

    @Override
    public BossArena getGame() {
        return (BossArena) super.getGame();
    }
}
