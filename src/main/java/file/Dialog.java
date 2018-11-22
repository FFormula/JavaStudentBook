package file;

import java.util.Scanner;

/**
 * Duomenu ivedimas is klaviaturos, isvedimas i ekrana
 */
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

    /**
     * Prasymas ivesti teksta
     * @param message prasymas
     * @return ivestas tekstas
     */
    public String input(String message) {
        print(message);
        return input();
    }
}
