package system.university.pds.model.creators;

import system.university.pds.model.ExcelGenerator;
import system.university.pds.model.FormatGenerator;
import system.university.pds.model.User;
import system.university.pds.model.interfaces.IFormatGenerator;

public class ExcelGeneratorCreator extends FormatGenerator {
    private User teacher;

    public ExcelGeneratorCreator(User teacher) {
        super(teacher);
    }

    @Override
    public IFormatGenerator createFormatGenerator() {
        return new ExcelGenerator(teacher);
    }
}
