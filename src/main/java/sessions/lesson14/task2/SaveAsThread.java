package sessions.lesson14.task2;

public class SaveAsThread implements Runnable {
    private int[] array;
    private FileUtil fileUtil;

    public SaveAsThread(int[] array, FileUtil fileUtil) {
        this.array = array;
        this.fileUtil = fileUtil;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        fileUtil.createFileIfNotExist();
        fileUtil.writeArrayToFile(array);
        System.out.println(Thread.currentThread().getName() + " finished!");
    }
}
