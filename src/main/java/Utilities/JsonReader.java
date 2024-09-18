package Utilities;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

    public static JSONObject readJsonData(String filePath) {
        JSONObject jsonObject = null;
        try {
            // Read JSON file into String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            // Convert String to JSON Object
            jsonObject = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
