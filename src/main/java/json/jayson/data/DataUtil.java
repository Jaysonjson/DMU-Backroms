package json.jayson.data;

import json.jayson.Backrooms;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class DataUtil {

    public static <T> void save(T data, String path) {
        try {
            FileUtils.writeStringToFile(new File(path), Backrooms.GSON.toJson(data), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public static <T> T load(String path, Class<T> clazz) {
        File dataFile = new File(path);
        if(dataFile.exists()) {
            try {
                return Backrooms.GSON.fromJson(new FileReader(dataFile), clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
