package file;

import data.Book;
import data.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    public final String FILENAME;

    public Storage(String filename) {
        FILENAME = filename;
    }

    public void save(Book book) {
        try (FileWriter writer = new FileWriter(FILENAME))
        {
            for (Point point : book.getPoints())
            {
                writer.write(point.getSubject() + "\n");
                writer.write(point.getTeacher() + "\n");
                writer.write(point.getPoint() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                int  pts = Integer.parseInt(reader.readLine());
                Point point = new Point(subject, teacher, pts);
                book.addPoint(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }
}
