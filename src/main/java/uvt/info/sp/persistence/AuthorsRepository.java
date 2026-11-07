package uvt.info.sp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uvt.info.sp.core.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
