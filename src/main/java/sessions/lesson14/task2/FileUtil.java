package sessions.lesson14.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileUtil {
    private File file;

    public FileUtil(File file) {
        this.file = file;
    }

    public synchronized void writeArrayToFile(int[] array) {
        System.out.println(Thread.currentThread().getName() + " writing to file started");
        try {
            Files.writeString(file.toPath(), Arrays.toString(array) + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " writing to file finished!");
    }

    public synchronized void createFileIfNotExist() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void clearFileContent() {
        if (file.exists()) {
            try (FileOutputStream writer = new FileOutputStream(file)) {
                writer.write(("").getBytes());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}