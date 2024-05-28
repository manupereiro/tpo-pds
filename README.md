# tpo-pds
Repo del TPO

El código de la consigna y sus tests se encuentran en la rama main.
En la carpeta documentation se encuentra el diagrama de la misma.

1ra entrega: 

- Para la realización del TPO nos parecio apropiado para tratar a los estudiantes y profesores, crear una clase abstracta de tipo User.
- Luego para tratar a los cursos y materias creamos dos clases concretas para cada una (Courses y Subject respectivamente).
- Para tener un control de la cantidad de materias a las que se puede anotar un estudiante creamos la clase Degree que tiene horas como uno de sus atributos.
- Dicha clase esta controlada por la clase University que es de tipo Singleton.
- Además las clases Student, Courses, Teacher, Order y Subject; todas cuentan con su controlador del tipo Singleton.
- Estas clases se utilizan de pasamanos para poder hacer la lógica del TPO. Igualmente no cuentan con lógica dentro, siendo estas clases también el patrón de diseño estructural Facade.
- Para realizar la generación del cronograma en formato PDF creamos la clase PDFGenerator que implementa la interfaz IFormatGenerator. Permitiendo así expandir a más formatos en posibles actualizaciones futuras.
- Una vez que el estudiante ya termina con el proceso de inscripción, generamos una orden de compra para los cursos con la clase Order. Esta clase se paga a través de la clase Payment que recibe el monto a pagar y su medio de pago.

2da Entrega:

- Cambios a clases preexistentes:

  - Lógica agregada a la clase profesor para mostrar días y turnos disponibles.
  - La clase TeacherController puede agregar horas a cada profesor.
  - Se agregaron los atributos día y turno a la clase curso. 
  - Se creó la clase enumeración Turn con las tres opciones posibles, mañana tarde o noche.
  - StudentController puede chequear materias por curso y por turno.

- Cambios principales:

  - Actualización de lógica de pago: A través del factory method, se crean tres distintas clases, MercadoPago, Binance y PagoMisCuentas. Estas clases implementan la clase abstract   PaymentMethod. Al mismo tiempo se crean las clases constructoras para cada una de ellas, las cuales implementan a la clase Payment.
  - Actualización de lógica de creación de archivos: A través del factory method, se crean dos clases, PDFGenerator y ExcelGenerator, las cuales implementan la interfaz IFormatGenerator.   Al mismo tiempo se crean sus respectivas clases constructoras, las cuales implementan la clase FormatGenerator. 
  - Creación de la clase ScheduleObserver. Cada vez que se agregue un nuevo profesor, esta clase automaticamente busca el mejor horario disponible y se lo asigna en el cronograma. 
  - Creación de la clase CourseObserver. Cada vez que un curso completa su cupo, esta clase automáticamente crea uno nuevo.
