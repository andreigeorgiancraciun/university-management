package university.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.management.model.LearnerProfile;

import java.util.List;

@Repository
public interface LearnerProfilesRepository extends JpaRepository<LearnerProfile, Long> {
    List<LearnerProfile> findAllByIsGraduatedIsFalseOrderByGpaDesc();
}
