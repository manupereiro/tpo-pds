package system.university.pds.model;

import lombok.Getter;
import system.university.pds.model.interfaces.IFormatGenerator;

import java.util.List;

@Getter
public abstract class FormatGenerator implements IFormatGenerator {
    private final List<Course> courses;
    private final String title;

    public FormatGenerator(User teacher){
        this.courses = teacher.getAssignedCourses();
        this.title = teacher.getName();
    }

    public abstract IFormatGenerator createFormatGenerator();

    public void formatTo(){
        IFormatGenerator formatGenerator = createFormatGenerator();
        formatGenerator.formatTo();
    }
}
