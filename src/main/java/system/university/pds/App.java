package system.university.pds;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import system.university.pds.controller.*;
import system.university.pds.model.*;
import system.university.pds.model.creators.MercadoPagoCreator;
import system.university.pds.model.creators.PDFGeneratorCreator;
import system.university.pds.model.interfaces.CourseObserver;
import system.university.pds.model.interfaces.IFormatGenerator;
import system.university.pds.model.interfaces.PaymentMethod;
import system.university.pds.model.interfaces.ScheduleObserver;

import java.math.BigInteger;
import java.time.DayOfWeek;
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

        /*
        * Segunda Entrega
        * Por cada curso se almacenará el turno en el cual se dicta, pudiendo ser mañana
        * (7:45 a 11:45), tarde (14:00 a 18:00) o noche (18:30 a 22:30).
        * */

        Course pdsCourse = new Course(pds, L001, (short) 68, 300, DayOfWeek.MONDAY, "MORNING");

        Course bdCourse = new Course(bd, L002, (short) 68, 1000, DayOfWeek.TUESDAY, "EVENING");

        Course oopCourse = new Course(oop, L203, (short) 68, 300, DayOfWeek.WEDNESDAY, "NIGHT");

        courseController.addCourse(pdsCourse);
        courseController.addCourse(oopCourse);
        courseController.addCourse(bdCourse);

        // Primera entrega - test 1: Cada estudiante deberá poder visualizar todos los cursos de una
        // materia dada para poder inscribirse

        pds.addCourse(pdsCourse);
        studentController.checkCourses(pds.getId());

        /*
        * Primera entrega - test 2:
        * En caso de inscribirse, el sistema deberá validar que el estudiante posee aprobadas las
        * correlativas anteriores.
        * La inscripción a cada materia solo está habilitada hasta el día estipulado por cada facultad.
        * El sistema deberá validar que la cantidad de cursos a los que se inscribe un estudiante en un
        * cuatrimestre no supere una carga horaria máxima que está determinada por la carrera a la que se encuentra
        * inscripto.
        *
        * */

        subjectController.Correlate(oop, pds);
        ((Student) bau).passSubject(oop);
        studentController.addStudent(bau);
        studentController.signUpToCourse(bau.getId(), pdsCourse.getId());

        /*
        * Primera entrega - test 3:
        * El sistema deberá redirigir al estudiante a Mercado Pago para abonar la primera cuota de los cursos a los que
        * se haya inscripto.
        *
        * 2da entrega:
        * El sistema deberá poder redirigir al estudiante a Mercado Pago, Pago Mis Cuentas, o Binance para abonar la
        * primera cuota de los cursos a los que se haya inscripto.
        *
        * */

        Order order = orderController.generateOrder(bau);
        MercadoPagoCreator mercadoPagoCreator = new MercadoPagoCreator(order);
        PaymentMethod mercadoPago = mercadoPagoCreator.createPaymentMethod();
        mercadoPago.pay(1000);

        /*
        * Primera entrega - test 4:
        * Cada docente deberá poder visualizar los cursos a los que se encuentra
        * asignado y el cronograma semanal de cursos. El sistema deberá poder generar un informe en formato PDF para
        * cada docente que incluya por cada curso asignado en un cuatrimestre el nombre, horario, y aula asignada.
        * */

        ana.addCourse(pdsCourse);
        teacherController.signUpToCourse(ana, pdsCourse.getId());
        PDFGenerator pdfGenerator = new PDFGenerator(ana);
        pdfGenerator.formatTo();

        /*
        * Segunda Entrega
        * El sistema deberá permitir al estudiante buscar cursos por turno y/o materia.
        * */

        studentController.checkCourses("MORNING");

        /*
         * Segunda entrega
         *El sistema deberá poder generar un informe en formato PDF o Excel para cada docente que incluya por
         * cada curso asignado en un cuatrimestre el nombre, horario, aula asignada, y cantidad de inscriptos.
         */

        PDFGeneratorCreator pdfGeneratorCreator = new PDFGeneratorCreator(ana);
        IFormatGenerator pdfFormat = pdfGeneratorCreator.createFormatGenerator();
        pdfFormat.formatTo();

        /*
        * Segunda Entrega
        * El docente podrá ingresar su disponibilidad horaria en días y turnos
        * */
        ((Teacher) ana).addAvailableDay(DayOfWeek.MONDAY);
        ((Teacher) ana).addAvailableDay(DayOfWeek.TUESDAY);
        ((Teacher) ana).addAvailableTurn(Turn.EVENING);
        ((Teacher) ana).addAvailableTurn(Turn.MORNING);

        /*
         * Segunda Entrega
         * El sistema deberá poder ofrecer por cada docente la cantidad de horas
         * asignadas mensualmente para que el sistema de recursos humanos genere la
         * liquidación correspondiente.
         */

        teacherController.assignHours((Teacher) ana, (short) 68);

        /*
        * Segunda Entrega
        * El sistema deberá poder generar cronogramas asignando cursos a docentes
        * según el turno programado para cada curso y la preferencia de cada docente
        * */

        Schedule schedule = new Schedule();
        ScheduleObserver scheduleObserver = schedule;
        teacherController.addObserver(scheduleObserver);
        teacherController.addTeacher(nico);
        teacherController.addTeacher(damian);

        /*
        * El sistema deberá poder ofrecer la cantidad de inscriptos por curso para que el
        * sistema de gestión académica pueda determinar si deben habilitarse nuevos
        * cursos.
        * */

        CourseObserver courseObserver = courseController;
        pdsCourse.addObserver(courseObserver);
        pdsCourse.addStudentToCourse(manu.getId());
        courseController.addStudentToRegisteredCourse(manu, pdsCourse.getId());

    }
}
