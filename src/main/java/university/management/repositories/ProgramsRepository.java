package university.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.management.model.Program;

import java.util.Optional;

@Repository
public interface ProgramsRepository extends JpaRepository<Program, Long> {
    Optional<Program> findByFieldOfStudyAndDegree(String fieldOfStudy, Program.Degree degree);
}
