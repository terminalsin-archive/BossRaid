package dev.ghast.bossraid.player;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import io.fairyproject.bukkit.listener.events.EventSubscribeBuilder;
import io.fairyproject.bukkit.listener.events.Events;
import io.fairyproject.bukkit.player.PlayerEventRecognizer;
import io.fairyproject.util.terminable.TerminableConsumer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.imanity.brew.Brew;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface PlayerListener extends TerminableConsumer {
    default <T extends Event & Cancellable> void cancelPlayer(Class<T> type) {
        this.cancelPlayer(type, EventPriority.NORMAL, Collections.emptyList());
    }

    default <T extends Event & Cancellable> void cancelPlayer(Class<T> type, EventPriority priority) {
        this.cancelPlayer(type, priority, (Predicate)null, (List)Collections.emptyList());
    }

    default <T extends Event & Cancellable> void cancelPlayer(Class<T> type, EventPriority priority, Predicate<Player> playerPredicate) {
        this.listenPlayer(type, priority, true, playerPredicate, Collections.emptyList()).listen(new Consumer[]{(event) -> {
            ((Cancellable)event).setCancelled(true);
        }}).build();
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        this.cancelPlayer(type, EventPriority.NORMAL, (List) ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        this.cancelPlayer(type, EventPriority.NORMAL, attributes);
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, EventPriority priority, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        this.cancelPlayer(type, priority, (Predicate)null, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, EventPriority priority, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        this.cancelPlayer(type, priority, (Predicate)null, (List)attributes);
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, EventPriority priority, Predicate<Player> playerPredicate, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        Preconditions.checkArgument(Cancellable.class.isAssignableFrom(type), "The event class wasn't extends on Cancellable");
        this.listenPlayer(type, priority, true, playerPredicate, (List)ImmutableList.copyOf(attributes)).listen(new Consumer[]{(event) -> {
            ((Cancellable)event).setCancelled(true);
        }}).build();
    }

    default <U extends Event, T extends U> void cancelPlayer(Class<T> type, EventPriority priority, Predicate<Player> playerPredicate, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        Preconditions.checkArgument(Cancellable.class.isAssignableFrom(type), "The event class wasn't extends on Cancellable");
        this.listenPlayer(type, priority, true, playerPredicate, attributes).listen(new Consumer[]{(event) -> {
            ((Cancellable)event).setCancelled(true);
        }}).build();
    }

    default <T extends Event> EventSubscribeBuilder<T> listenPlayer(Class<T> type) {
        return this.listenPlayer(type, EventPriority.NORMAL);
    }

    default <T extends Event> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority) {
        return this.listenPlayer(type, priority, false);
    }

    default <T extends Event> EventSubscribeBuilder<T> listenPlayer(Class<T> type, boolean ignoreCancelled) {
        return this.listenPlayer(type, EventPriority.NORMAL, ignoreCancelled);
    }

    default <T extends Event> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled) {
        return this.listenPlayer(type, priority, ignoreCancelled, (Predicate)null);
    }

    default <T extends Event> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled, Predicate<Player> playerPredicate) {
        return this.listenPlayer(type, priority, ignoreCancelled, playerPredicate, Collections.emptyList());
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        return this.listenPlayer(type, EventPriority.NORMAL, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        return this.listenPlayer(type, EventPriority.NORMAL, attributes);
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        return this.listenPlayer(type, priority, false, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        return this.listenPlayer(type, priority, false, attributes);
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, boolean ignoreCancelled, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        return this.listenPlayer(type, EventPriority.NORMAL, ignoreCancelled, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, boolean ignoreCancelled, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        return this.listenPlayer(type, EventPriority.NORMAL, ignoreCancelled, attributes);
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        return this.listenPlayer(type, priority, ignoreCancelled, (Predicate)null, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        return this.listenPlayer(type, priority, ignoreCancelled, (Predicate)null, (List)attributes);
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled, Predicate<Player> playerPredicate, Class<? extends PlayerEventRecognizer.Attribute<U>>... attributes) {
        return this.listenPlayer(type, priority, ignoreCancelled, playerPredicate, (List)ImmutableList.copyOf(attributes));
    }

    default <U extends Event, T extends U> EventSubscribeBuilder<T> listenPlayer(Class<T> type, EventPriority priority, boolean ignoreCancelled, Predicate<Player> playerPredicate, List<Class<? extends PlayerEventRecognizer.Attribute<U>>> attributes) {
        if (!PlayerEventRecognizer.isTypePossible(type) && attributes.size() == 0) {
            throw new UnsupportedOperationException("Impossible to get Player from event type " + type.getSimpleName());
        } else {
            EventSubscribeBuilder<T> builder = Events.subscribe(type).priority(priority).forPlayer(this.getPlayer());
            if (ignoreCancelled && Cancellable.class.isAssignableFrom(type)) {
                builder.filter((event) -> {
                    return !((Cancellable)event).isCancelled();
                });
            }

            return builder.filter((event) -> {
                Player player = PlayerEventRecognizer.tryRecognize(event, (Class[])attributes.toArray(new Class[0]));
                if (player == null) {
                    return false;
                } else {
                    // TODO:    Double check this isn't useless
                    return this.getPlayer().equals(player) && (playerPredicate == null || playerPredicate.test(player));
                }
            }).plugin(Brew.INSTANCE.getPlugin()).bindWith(this);
        }
    }


    Player getPlayer();
}
