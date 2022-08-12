package dev.ghast.bossraid.arena.impl;

import dev.ghast.bossraid.arena.BossArena;
import dev.ghast.bossraid.arena.BossArenaState;

public class ClosedState extends BossArenaState {
    public ClosedState(BossArena parent) {
        super(parent);
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onUpdate() {

    }

    @Override
    protected void onEnded() {

    }

    @Override
    public boolean isConnectable() {
        return false;
    }
}
