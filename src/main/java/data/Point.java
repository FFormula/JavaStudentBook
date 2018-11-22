package data;

/**
 * Pzymiu irasas
 */
public class Point {
    private String subject;
    private String teacher;
    private int point;

    /**
     * Pazymio registravimas
     * @param subject dalyko pavadinimas
     * @param teacher destytojo vardas/pavarde
     * @param point pazymis nuo 1 iki 10
     */
    public Point(String subject, String teacher, int point) {
        if (point < 1 || point > 10)
            throw new IllegalArgumentException(
                    "Point must be from 1 to 10, given: " + point);
        this.subject = subject;
        this.teacher = teacher;
        this.point = point;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Dalykas: " + subject +
             ", Destytojas: " + teacher +
             ", Pazymis: " + point;
    }
}
