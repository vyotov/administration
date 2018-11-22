import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
A School has a name, an opening date and a collection of courses.
Name and opening date are not allowed to be null.
You can add a course to the school.
Course begin dates are after the school begin date. Throw a CourseException when it’s wrong.
The name of the course within a school is unique, otherwise a DuplicateCourseException is thrown.
You can get a course by name.
You can get a list of all course names.
You can get a list of copies of all courses

 */

public class SchoolTest {

    @Test
    public void schoolShouldHasNameOpeningDateAndCollectionOfCourses() throws ParseException {
        //arrange
        boolean expect = true;
        boolean result = false;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date openingDate = dateformat.parse("15/09/2018");
        List<Course> listOfCourses = new ArrayList<Course>();
        //act
        School school = new School();
        school.setName("Fontys");
        school.setOpeningDate(openingDate);
        school.setCollectionOfCourses(listOfCourses);


        if (school.getOpeningDate() != null && school.getName()!= null && school.getCollectionOfCourses()!= null) {
            result = true;
        }
        //assert
        Assert.assertEquals("School has name opening date and a collection of courses",expect,result);
    }
}