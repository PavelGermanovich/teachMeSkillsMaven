package sessions.lesson17;

public class Demo {
    public static void main(String[] args) {
        Printable printXiaomi = (str) -> System.out.println("Xiaomi printer printing " + str);
        Printable printSamsung = (str) -> System.out.println("Samsung printer printing " + str);

        Printer printer = new Printer();
        printer.print(printXiaomi, "text for first lambda");
        printer.print(printSamsung, "text for the second lambda");
    }
}
