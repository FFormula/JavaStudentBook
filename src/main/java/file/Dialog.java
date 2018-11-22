package file;

import java.util.Scanner;

public class Dialog {

    Scanner scanner = new Scanner(System.in);

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public String input() {
        return scanner.nextLine();
    }

    public String input(String message) {
        print(message);
        return input();
    }
}
