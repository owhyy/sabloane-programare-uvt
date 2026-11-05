package uvt.info.sp.web.services;

import org.springframework.stereotype.Service;
import uvt.info.sp.core.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Book> findAll() {
        return books.values().stream().toList();
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book create(String title) {
        Long id = nextId.getAndIncrement();
        Book book = new Book(title);
        books.put(id, book);
        return book;
    }

    public Optional<Book> replace(Long id, String title) {
        Book replacement = new Book(title);
        if (books.replace(id, replacement) == null) {
            return Optional.empty();
        }
        return Optional.of(replacement);
    }

    public boolean delete(Long id) {
        return books.remove(id) != null;
    }

}
