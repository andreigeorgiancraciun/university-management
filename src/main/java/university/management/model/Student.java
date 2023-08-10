package university.management.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 60)
    private String firstName;

    @NotNull
    @Column(nullable = false, length = 60)
    private String lastName;

    @NotNull
    @Column(nullable = false, length = 60)
    private String email;

    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private LearnerProfile learnerProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToMany(mappedBy = "enrolledStudents",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Course> enrolledIn;

    public Student(String firstName,
                   String lastName,
                   String email,
                   LocalDate dateOfBirth,
                   Program program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.learnerProfile = new LearnerProfile((short) LocalDate.now().getYear());
        this.program = program;
    }
}
