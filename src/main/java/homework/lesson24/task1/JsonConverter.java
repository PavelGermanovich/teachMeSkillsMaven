package homework.lesson24.task1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverter {
    public static void convertFlatToJson(Flat flat) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/java/homework/lesson24/task1/flat.txt"), flat);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String convertFlatToJsonString(Flat flat) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(flat);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Flat getFlatFromJsonFile(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Flat flatFromJson = objectMapper.readValue(file, Flat.class);
            return flatFromJson;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Flat getFlatFromJsonString(String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Flat flatFromJs = objectMapper.readValue(jsonStr, Flat.class);
            return flatFromJs;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
