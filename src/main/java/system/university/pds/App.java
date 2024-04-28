package system.university.pds;

import system.university.pds.controller.*;
import system.university.pds.model.*;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        CourseController courseController = CourseController.getInstance();
        OrderController orderController = OrderController.getInstance();
        StudentController studentController = StudentController.getInstance();
        SubjectController subjectController = SubjectController.getInstance();
        TeacherController teacherController = TeacherController.getInstance();

        University uade = University.getInstance();

        Degree informatica = new Degree("Ingenieria en Informatica", (short) 390);
        Degree grafico = new Degree("Diseño Grafico", (short) 300);
        Degree industrial = new Degree("Ingenieria Industrial", (short) 400);

        User bau = new Student("Bautista", "bauticrack02", informatica.getId());
        User manu = new Student("Manuel", "manucabj12", informatica.getId());
        User juan = new Student("Juan", "volveraobera123", informatica.getId());
        User santi = new Student("Santiago", "mickyteamoxoxo", informatica.getId());
        User sofi =  new Student("Sofia", "believer123", informatica.getId());
        User rena = new Student("Candela", "feudislifestyle", informatica.getId());


        Subject pds = new Subject("Procesos de Desarrollo de Software", new Date(), new Date(2024, 5, 1));
        Subject bd = new Subject("Base de Datos", new Date(), new Date(2024, 5, 1));
        Subject oop = new Subject("Orientada a Objetos", new Date(), new Date(2024, 5, 1));

        subjectController.addSubject(pds);
        subjectController.addSubject(bd);
        subjectController.addSubject(oop);

        User ana = new Teacher("Ana", "analamascrack");
        User nico = new Teacher("Nicolas", "lamalditacabra");
        User damian = new Teacher("Damian", "godiolover4Life");

        teacherController.addTeacher(ana);

        Classroom L001 = new Classroom(1, (short) 30);
        Classroom L002 = new Classroom(2, (short) 30);
        Classroom L203 = new Classroom(203, (short) 40);


        uade.addDegree(informatica);

        Course pdsCourse = new Course(pds, L001, LocalTime.of(
                7,45,0), LocalTime.of(11,45,0), (short) 4, 1000);

        Course bdCourse = new Course(bd, L002,LocalTime.of(
                7,45,0), LocalTime.of(11,45,0), (short) 4, 1000);

        Course oopCourse = new Course(oop, L203,LocalTime.of(
                7,45,0), LocalTime.of(11,45,0), (short) 4, 1000);

        courseController.addCourse(pdsCourse);
        courseController.addCourse(oopCourse);
        courseController.addCourse(bdCourse);

        // test 1: Cada estudiante deberá poder visualizar todos los cursos de una materia dada para poder inscribirse

        pds.addCourse(pdsCourse);
        studentController.checkCourses(pds.getId());

        /*
        * test 2:
        * En caso de inscribirse, el sistema deberá validar que el estudiante posee aprobadas las correlativas anteriores.
        * La inscripción a cada materia solo está habilitada hasta el día estipulado por cada facultad.
        * El sistema deberá validar que la cantidad de cursos a los que se inscribe un estudiante en un
        * cuatrimestre no supere una carga horaria máxima que está determinada por la carrera a la que se encuentra
        *  inscripto.
        *
        * */


        subjectController.Correlate(oop, pds);
        ((Student) bau).passSubject(oop);
        studentController.addStudent(bau);
        studentController.signUpToCourse(bau.getId(), pdsCourse.getId());


        /*
        * test 3:
        * El sistema deberá redirigir al estudiante a Mercado Pago para abonar la primera cuota de los cursos a los que
        * se haya inscripto.
        * */

        Order order = orderController.generateOrder(bau);
        Payment payment = new Payment(order, new MercadoPago(1000));
        payment.pay(1000);

        /*
        * test 4:
        * Cada docente deberá poder visualizar los cursos a los que se encuentra
        * asignado y el cronograma semanal de cursos. El sistema deberá poder generar un informe en formato PDF para
        *  cada docente que incluya por cada curso asignado en un cuatrimestre el nombre, horario, y aula asignada.
        * */

        ana.addCourse(pdsCourse);
        teacherController.signUpToCourse(ana, pdsCourse.getId());
        PDFGenerator pdfGenerator = new PDFGenerator(ana);
        pdfGenerator.formatTo();

    }
}
