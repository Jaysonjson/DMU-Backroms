package json.jayson.data;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Collection;

public class BackroomLevel {

    private String id;
    private String name;

    private Collection<BlockPos> exits = new ArrayList<>();
    private Collection<BlockPos> mobs = new ArrayList<>();
    private Collection<BlockPos> spawns = new ArrayList<>();

    public BackroomLevel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Collection<BlockPos> getExits() {
        return exits;
    }

    public Collection<BlockPos> getMobs() {
        return mobs;
    }

    public Collection<BlockPos> getSpawns() {
        return spawns;
    }

}
