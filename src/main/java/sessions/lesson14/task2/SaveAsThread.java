package sessions.lesson14.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class SaveAsThread implements Runnable {
    private int[] array;
    private final Path filePathToWrite = Path.of("src/main/java/sessions/lesson14/task2/result.txt");

    public SaveAsThread(int[] array) {
        this.array = array;
    }

    //toDo общий объект должен быть?
    public synchronized void writeArrayToFile() {
        File file = new File(String.valueOf(filePathToWrite));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Files.writeString(filePathToWrite, Arrays.toString(array) + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        writeArrayToFile();
    }
}
