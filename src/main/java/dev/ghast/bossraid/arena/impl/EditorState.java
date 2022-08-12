package dev.ghast.bossraid.arena.impl;

import dev.ghast.bossraid.arena.BossArena;
import dev.ghast.bossraid.arena.BossArenaState;
import dev.ghast.bossraid.util.game.CachedInventory;
import org.bukkit.entity.Player;
import org.imanity.brew.game.event.GameJoinEvent;
import org.imanity.brew.game.event.GameQuitEvent;

public class EditorState extends BossArenaState {
    public EditorState(BossArena parent) {
        super(parent);
    }

    @Override
    protected void onStart() {
        this.listenPlayer(GameJoinEvent.class).listen(gameJoinEvent -> {
            final Player player = gameJoinEvent.getPlayer();


            player.sendTitle(
                    "&cWelcome to the Editor",
                    "&cCurrently editing &r" + this.getGameName(),
                    10,
                    40,
                    10
            );

            // TODO:    Editor item logic here

        }).build();

        this.listenPlayer(GameQuitEvent.class).listen(gameQuitEvent -> {
            final Player player = gameQuitEvent.getPlayer();

        }).build();
    }

    @Override
    protected void onUpdate() {

    }

    @Override
    protected void onEnded() {
        for (Player player : this.getGame().getPlayers()) {
            this.getGame().removePlayer(player);

            player.sendTitle(
                    "&bSaving game...",
                    "&7You will be transported back to home",
                    10,
                    60,
                    10
            );
        }
    }

    @Override
    public boolean isConnectable() {
        return false;
    }
}
