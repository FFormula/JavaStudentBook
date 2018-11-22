import data.Book;
import data.Point;
import file.Dialog;
import file.Storage;

import java.io.IOException;

/**
 * Programos logika
 */
class Program {
    private Book book;
    private Dialog dialog;
    private Storage storage;

    /**
     * Veiksmu pasirinkimas ir vykdimas
     */
    void start() {
        doInit();
        while (true) {
            doShowMenu();
            String item = dialog.input("Iveskite meniu punkta: ");
            switch (item) {
                case "1": doAddPoint(); break;
                case "2": doShowPoints(); break;
                case "3": doShowAverage(); break;
                case "0": if (doExit()) return;
                          break;
                default : dialog.println("Iveskite skaici nuo 0iki 3");
            }
        }
    }

    private void doInit() {
        dialog = new Dialog();
        String student = dialog.input("Iveskite studento numeri: ");
        storage = new Storage(student + ".txt");
        book = storage.load();
    }

    private void doShowMenu() {
        dialog.println("--= MENIU =--");
        dialog.println("1. Prideti pazyma");
        dialog.println("2. Isvesti pazymus");
        dialog.println("3. Parodyti vidurki");
        dialog.println("0. Baigti darba");
    }

    private void doAddPoint() {
        String subject = dialog.input("Iveskite dalyka: ");
        String teacher = dialog.input("Iveskite mokytoja: ");
        int pts = Integer.parseInt(dialog.input("Iveskite pazymi (1-10): "));
        Point point = new Point(subject, teacher, pts);
        book.addPoint(point);
    }

    private void doShowPoints() {
        if (book.getPoints().size() == 0)
            dialog.println("Pazymiu sarasas yra tuscias");
        for (Point point : book.getPoints())
            dialog.println(point+"");
    }

    private void doShowAverage() {
        dialog.println("Visu pazymiu vidurkis yra: " +
                book.getAveragePoint());
    }

    private boolean doExit() {
        try {
            storage.save(book);
            dialog.println("Studiju knygele issaugota.");
            return true;
        } catch (IOException e) {
            dialog.println("Studiju knygele issaugoti NEPAVYKO.");
            return false;
        }
    }
}
