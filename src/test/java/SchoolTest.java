import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*



You can get a list of all course names.
You can get a list of copies of all courses

 */

public class SchoolTest {


    private void fillInCourse(School school) throws ParseException {
        List<Course> collectionOfCourses = new ArrayList<Course>();
        Course math = new Course();
        Course tci = new Course();
        Course os = new Course();
        math.setName("Math");
        tci.setName("TCI");
        os.setName("OS");

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        math.setStartDate(dateformat.parse("12/11/2018"));
        tci.setStartDate(dateformat.parse("15/12/2018"));
        os.setStartDate(dateformat.parse("15/10/2018"));

        school.setOpeningDate(dateformat.parse("14/10/2018"));

        collectionOfCourses.add(math);
        collectionOfCourses.add(tci);
        collectionOfCourses.add(os);

        school.setCollectionOfCourses(collectionOfCourses);
    }
    @Test
    public void getListOfAllCourses() throws ParseException{
        boolean expect = true;
        boolean result = false;
        School school = new School();
        fillInCourse(school);
        if(school.getCollectionOfCourses()!=null){
            result = true;
        }
        Assert.assertEquals("Get list of all courses",expect,result);
    }
    @Test
    public void getCourseByName() throws ParseException {
        boolean expect = true;
        boolean result = false;
        Course course = new Course();
        course.setName("TestCourse");
        if(course.getName()!=null){
            result = true;
        }
        Assert.assertEquals("The course name can be got",expect,result);

    }
    @Test
    public void uniqueCourseName() throws DuplicateCourseException, ParseException {
        boolean expect = true;
        boolean result = false;

        School school = new School();
        fillInCourse(school);
        List<Course> collectionOfCourses = new ArrayList<Course>();
        collectionOfCourses = school.getCollectionOfCourses();
        Course math1 = new Course();
        math1.setName("Math");
        if(!collectionOfCourses.contains(math1.getName())){
            result = true;
        } else {throw  new DuplicateCourseException("The name is not unique");}
        Assert.assertEquals("The course name is unique",expect,result);
    }
    @Test
    public void courseBeginDatesAreAfterTheBeginDate() throws CourseDateException,ParseException{
        boolean expect = true;
        boolean result = false;

        School school = new School();
        fillInCourse(school);
        for (Course course : school.getCollectionOfCourses())
              {
                  if(course.getStartDate().after(school.getOpeningDate())){
                  result = true;
                  }else { throw new CourseDateException("The starting date of the course is before the opening date of the school");}
              }
        Assert.assertEquals("The starting date of the course is after the opening date of the school",expect,result);
    }
    @Test
    public void isAddingCourseCorrect(){
        boolean expect = true;
        boolean result = false;
        School school = new School();
        Course course = new Course();
        List<Course> courseList = new ArrayList<Course>();
        school.setCollectionOfCourses(courseList);
        school.add(course);
        if(school.getCollectionOfCourses().contains(course)){
            result = true;
        }

        Assert.assertEquals("A course has been added",expect,result);
    }
    @Test
    public void schoolNameAndOpeningDateAreNotNull() throws ParseException {
        boolean expect = true;
        boolean resultDate = false;
        boolean resultName = false;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date openingDate = dateformat.parse("15/09/2018");
        //act
        School school = new School();
        school.setName("Fontys");
        school.setOpeningDate(openingDate);
        if (school.getName()!= null){
            resultName = true;
        }
        if (school.getOpeningDate()!= null){
            resultDate = true;
        }
        school.setOpeningDate(openingDate);
        Assert.assertEquals("School opening date in not null",expect,resultDate);
        Assert.assertEquals("School name is not null",expect,resultName);
    }
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