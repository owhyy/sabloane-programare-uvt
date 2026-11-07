package uvt.info.sp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uvt.info.sp.core.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}
