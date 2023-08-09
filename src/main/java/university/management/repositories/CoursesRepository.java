package university.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.management.model.Course;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
}
