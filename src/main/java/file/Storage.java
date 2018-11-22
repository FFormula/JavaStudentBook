package file;

import data.Book;
import data.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Knygeles saugojimas i faila ir pasikraunimas is failo
 */
public class Storage {

    private final String FILENAME;

    public Storage(String filename) {
        FILENAME = filename;
    }

    /**
     * Issagoti knygele i faila
     * @param book knygele
     * @throws IOException jei nepavyks irasyti
     */
    public void save(Book book) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);
        for (Point point : book.getPoints())
        {
            writer.write(point.getSubject() + "\n");
            writer.write(point.getTeacher() + "\n");
            writer.write(point.getPoint() + "\n");
        }
        writer.close();
    }

    public Book load() {
        Book book = new Book();
        try (
                FileReader fileReader = new FileReader(FILENAME);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String subject;
            while (null != (subject = reader.readLine())) {
                String teacher = reader.readLine();
                int pts = Integer.parseInt(reader.readLine());
                Point point = new Point(subject, teacher, pts);
                book.addPoint(point);
            }
            return book;
        } catch (IOException e) {
            return book;
        }
    }
}
