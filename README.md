# tpo-pds
Repo del TPO

El código de la consigna y sus tests se encuentran en la rama main.
En la carpeta documentation se encuentra el diagrama de la misma.

Primera entrega: 
- Para la realización del TPO nos parecio apropiado para tratar a los estudiantes y profesores, crear una clase abstracta de tipo User.
- Luego para tratar a los cursos y materias creamos dos clases concretas para cada una (Courses y Subject respectivamente).
- Para tener un control de la cantidad de materias a las que se puede anotar un estudiante creamos la clase Degree que tiene horas como uno de sus atributos.
- Dicha clase esta controlada por la clase University que es de tipo Singleton.
- Además las clases Student, Courses, Teacher, Order y Subject; todas cuentan con su controlador del tipo Singleton.
- Estas clases se utilizan de pasamanos para poder hacer la lógica del TPO. Igualmente no cuentan con lógica dentro, siendo estas clases también el patrón de diseño estructural Facade.
- Para realizar la generación del cronograma en formato PDF creamos la clase PDFGenerator que implementa la interfaz IFormatGenerator. Permitiendo así expandir a más formatos en posibles actualizaciones futuras.
- Una vez que el estudiante ya termina con el proceso de inscripción, generamos una orden de compra para los cursos con la clase Order. Esta clase se paga a través de la clase Payment que recibe el monto a pagar y su medio de pago.
