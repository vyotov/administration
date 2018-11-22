import java.util.*;

public class School {

    private String name;
    private Date openingDate;
    private List<Course> collectionOfCourses;

    public String getName() {
        return this.name;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void setCollectionOfCourses(List<Course> collectionOfCourses) {
        this.collectionOfCourses = collectionOfCourses;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public List<Course> getCollectionOfCourses() {
        return collectionOfCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Course course) {
        this.collectionOfCourses.add(course);
    }
}
