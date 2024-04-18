package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Student;
import system.university.pds.model.Subject;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StudentController {

    private final Map<BigInteger, Student> students;

    public StudentController() {
        this.students = new HashMap<>();
    }

    public void signUpToCourse(BigInteger studentId, BigInteger courseId){
        CourseController courseController = new CourseController();
        Student student = students.get(studentId);
        Course course = courseController.getCourse(courseId);
        Subject subject = course.getSubject();

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        if (date.before(subject.getStartingDay()) || date.after(subject.getDeadline())){
            return;
        }

        boolean prerequisitesCourses = course.checkPrerequisitesCourses(student);
        boolean scheduleIsNotFull = course.checkTotalHours(student.getCoursesEnrolled());

        if (prerequisitesCourses && scheduleIsNotFull){
            course.addStudentToCourse(student.getId());
            courseController.addStudentToRegisteredCourse(student, course.getId());

            /*
            * Una vez que el estudiante se incribio to-do correcto hay que generar la orden de pago
            * Tambien falto lo del dia estipulado por la facultad eso es previo a que el estudiante
            * pueda anotarse a una materia que quiere
             */
        }
    }
}
