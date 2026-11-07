package uvt.info.sp.web.commands;

import lombok.RequiredArgsConstructor;
import uvt.info.sp.core.Book;

@RequiredArgsConstructor
public class CreateBookCommand implements Command<Book> {
    private final String title;

    @Override
    public Book execute(CommandContext context) {
        Book book = new Book(title);
        return context.booksRepository().save(book);
    }
}
