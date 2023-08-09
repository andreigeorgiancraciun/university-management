package university.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Programs")
@Getter
@Setter
@NoArgsConstructor
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @Column(nullable = false)
    private final int requiredYearsToGraduation = 4 ;

    @Column(nullable = false)
    private final int requiredCreditsToGraduation = 200;

    @Column(nullable = false, updatable = false)
    private String fieldOfStudy;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToMany(mappedBy = "program")
    private final List<Student> students = new ArrayList<>();

    public Program(String fieldOfStudy, Degree degree) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
    }

    public enum Degree {
        ASSOCIATE,
        BACHELOR,
        MASTER,
        PHD,
    }
}
