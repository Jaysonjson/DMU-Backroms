package json.jayson.data;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;

public class BackroomData {

    public Collection<BackroomLevel> LEVELS = new ArrayList<>();
    public String startingLevel = "";

    @Nullable
    public BackroomLevel getLevel(String id) {
        return LEVELS.stream()
                .filter(level -> level.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
