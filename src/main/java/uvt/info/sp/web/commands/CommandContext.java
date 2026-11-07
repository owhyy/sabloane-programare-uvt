package uvt.info.sp.web.commands;

import uvt.info.sp.persistence.CrudRepository;
import uvt.info.sp.core.Book;

public record CommandContext(CrudRepository<Book, Long> booksRepository) {
}
