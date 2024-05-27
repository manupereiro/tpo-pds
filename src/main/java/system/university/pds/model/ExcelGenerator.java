package system.university.pds.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import system.university.pds.model.interfaces.IFormatGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class ExcelGenerator implements IFormatGenerator {
    private final List<Course> courses;
    private final String title;
    private final String filePath;

    public ExcelGenerator(User teacher) {
        this.courses = teacher.getAssignedCourses();
        this.title = teacher.getName();
        this.filePath = teacher.getId() + ".xlsx";
    }

    @Override
    public void formatTo() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cursos");

        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        titleStyle.setFont(titleFont);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(this.title);
        titleCell.setCellStyle(titleStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        Row headerRow = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("Nro");
        headerRow.createCell(1).setCellValue("Curso");
        headerRow.createCell(2).setCellValue("Horario");
        headerRow.createCell(3).setCellValue("Aula");

        int rowNum = 2;
        for (Course course : this.courses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(course.getId());
            row.createCell(1).setCellValue("nombremateria");
            row.createCell(2).setCellValue(getStartTime(course) + " - " + getEndTime(course));
            row.createCell(3).setCellValue(String.valueOf(course.getClassroom().getClassroomNumber()));
        }

        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(this.filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private LocalTime getStartTime(Course course) {
        switch (course.getTurn()) {
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

    private LocalTime getEndTime(Course course) {
        switch (course.getTurn()) {
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
