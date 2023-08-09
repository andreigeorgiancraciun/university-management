package university.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LearnerProfiles")
@Getter
@Setter
@NoArgsConstructor
public class LearnerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private int numberOfCredits;
    private float gpa; // grade point average
    private boolean isGraduated;
    private short startYear;

    @OneToOne(mappedBy = "learnerProfile")
    private Student student;

    public LearnerProfile(short startYear) {
        this.startYear = startYear;
    }
}
