import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;
/*
•	The end date should be after the begin date, otherwise a CourseDateException is thrown.

 */
public class CourseTest {

    @Test
    public void endDateShouldBeAfterBeginDate() throws CourseDateException, ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = dateformat.parse("15/09/2018");
        Date endDate = dateformat.parse("15/11/2018");

        boolean expect = true;
        boolean actual = false;
        Course course = new Course();
        course.setStartDate(startDate);
        course.setEndDate(endDate);

        if (course.getEndDate().after(course.getStartDate)){
            actual = true;
        }

        Assert.assertEquals("The end date is after the begin date",expect,actual);
    }

}