import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonToFile {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("/home/pushkar/Desktop/IDEA_PROJECTS/XML_JSON/src/main/java/test.json"));

            JSONObject jsonObject = (JSONObject) obj;
//
            JSONArray msg = (JSONArray) jsonObject.get("Employees");
            JSONObject jsonObject1 = (JSONObject) msg.get(2);
            String s = (String) jsonObject1.get("lastName");
            System.out.println(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}