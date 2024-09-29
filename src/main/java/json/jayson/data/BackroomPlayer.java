package json.jayson.data;

import json.jayson.Backrooms;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.ListNBT;

public class BackroomPlayer {

    private transient BackroomLevel level;
    private transient PlayerEntity player;
    private ListNBT originalInventory = new ListNBT();
    private String currentLevel = "";

    public BackroomLevel getLevel() {
        return level;
    }

    /*public void clearInventory() {
        for (int i = 0; i < player.inventory.getContainerSize(); i++) {
            CompoundNBT nbt = player.inventory.getItem(i).getOrCreateTag();
            if(nbt.contains("BackroomsPrize")) continue;
            player.inventory.setItem(i, ItemStack.EMPTY);
        }
    }*/

    public void enterBackrooms() {
        player.inventory.save(originalInventory);
    }

    public void nextLevel() {

    }

    public void leaveBackrooms() {
        player.inventory.load(originalInventory);
    }

    public void save() {
        currentLevel = level.getId();
        DataUtil.save(this, "backrooms/player/" + player.getUUID() + ".json");
    }

    public static BackroomPlayer load(PlayerEntity player) {
        BackroomPlayer backroomPlayer = DataUtil.load("backrooms/player/" + player.getUUID() + ".json", BackroomPlayer.class);
        if(backroomPlayer != null) {
            backroomPlayer.player = player;
            backroomPlayer.level = Backrooms.DATA.getLevel(backroomPlayer.currentLevel);
        }
        return backroomPlayer;
    }
}
