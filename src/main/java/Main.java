import data.Book;
import data.Point;
import file.Storage;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.addPoint(new Point("Java", "Volosatov", 10));
        book.addPoint(new Point("PHP", "Volosatov", 10));
        book.addPoint(new Point("C#", "Volosatov", 10));

        Storage storage = new Storage("baranauskas.txt");
        storage.save(book);
    }
}
