package system.university.pds.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import system.university.pds.model.interfaces.IFormatGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.List;

public class PDFGenerator implements IFormatGenerator {
    private final List<Course> courses;
    private final String title;
    private final String filePath;

    public PDFGenerator(User teacher){
        this.courses = teacher.getAssignedCourses();
        this.title = teacher.getName();
        this.filePath = teacher.getId() + ".pdf";
    }

    @Override
    public void formatTo(){

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(this.filePath));
            document.open();

            Paragraph title = new Paragraph(this.title);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            PdfPTable table = getPdfPTable();

            document.add(table);

            document.close();

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private PdfPTable getPdfPTable() {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);

        table.addCell("Nro");
        table.addCell("Curso");
        table.addCell("Horario");
        table.addCell("Aula");

        for (Course course : this.courses){
            table.addCell(String.valueOf(course.getId()));
            // table.addCell(course.getName());
            table.addCell("nombremateria");
            table.addCell(getStartTime(course) + " - " + getEndTime(course));
            table.addCell(String.valueOf(course.getClassroom().getClassroomNumber()));
        }
        return table;
    }

    private LocalTime getStartTime(Course course){
        switch (course.getTurn()){
            case MORNING:
                return LocalTime.of(7, 45);
            case EVENING:
                return LocalTime.of(14, 0);
            case NIGHT:
                return LocalTime.of(18, 30);
            default:
                return null;
        }
    }

    private LocalTime getEndTime(Course course){
        switch (course.getTurn()){
            case MORNING:
                return LocalTime.of(11, 45);
            case EVENING:
                return LocalTime.of(18, 0);
            case NIGHT:
                return LocalTime.of(22, 30);
            default:
                return null;
        }
    }
}
