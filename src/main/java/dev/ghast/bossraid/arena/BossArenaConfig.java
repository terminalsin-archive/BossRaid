package dev.ghast.bossraid.arena;

import dev.ghast.bossraid.util.Region3i;
import dev.ghast.bossraid.util.Vec3i;
import io.lumine.mythic.api.mobs.MythicMob;
import lombok.Data;

import java.util.List;

@Data
public class BossArenaConfig {
    private String name;

    private Region3i enterRegion;

    private Vec3i bossSpawn;

    private List<Vec3i> playerSpawns;

    private String bossMob;


}
