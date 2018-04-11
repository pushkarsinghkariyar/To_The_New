import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileToJson {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Pushkar Singh");
        obj.put("age", new Integer(22));

        JSONArray list = new JSONArray();
        list.add("JVM");
        list.add("C++");
        list.add("Python");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("/home/pushkar/Desktop/IDEA_PROJECTS/XML_JSON/src/main/java/testing.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}