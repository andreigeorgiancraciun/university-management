package university.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    private String description;
    private int numberOfCredits;

    @ManyToMany
    @JoinTable(name = "COURSE_ENROLLMENTS",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "enrolled_student_id", referencedColumnName = "id"))
    private Set<Student> enrolledStudents;

    public Course(String title, String description, int numberOfCredits) {
        this.title = title;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public void addEnrolledStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeEnrolledStudent(Student student) {
        enrolledStudents.remove(student);
    }
}
