package sessions.lesson16.taskOne;

public class Demo {
    public static void main(String[] args) {
        SaveToDatabase saveToDatabaseOracle = () -> "Oracle save";
        System.out.println(saveToDatabaseOracle.saveToDb());

        SaveToDatabase saveToDatabaseMysql = () -> "Mysql save";
        System.out.println(saveToDatabaseMysql.saveToDb());
    }
}
