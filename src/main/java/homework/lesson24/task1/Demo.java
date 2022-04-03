package homework.lesson24.task1;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
        Flat myFlat = new Flat();
        myFlat.addRoom(new Room("Bedroom", 17));
        myFlat.addRoom(new Room("Studio", 30));
        JsonConverter.convertFlatToJson(myFlat);
        System.out.println(JsonConverter.convertFlatToJsonString(myFlat));

        Flat flatFromJsonFile = JsonConverter.getFlatFromJsonFile(new File("src/main/java/homework/lesson24/task1/flat.txt"));
        System.out.println("Flat extracted from Json " + flatFromJsonFile);

        System.out.println(JsonConverter.getFlatFromJsonString(JsonConverter.convertFlatToJsonString(myFlat)));
    }
}
