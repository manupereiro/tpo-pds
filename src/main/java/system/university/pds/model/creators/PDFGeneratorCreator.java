package system.university.pds.model.creators;

import system.university.pds.model.FormatGenerator;
import system.university.pds.model.PDFGenerator;
import system.university.pds.model.User;
import system.university.pds.model.interfaces.IFormatGenerator;

public class PDFGeneratorCreator extends FormatGenerator {
    private User teacher;

    public PDFGeneratorCreator(User teacher) {
        super(teacher);
        this.teacher = teacher;
    }
    @Override
    public IFormatGenerator createFormatGenerator() {
        return new PDFGenerator(teacher);
    }
}
