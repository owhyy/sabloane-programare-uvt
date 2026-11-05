package uvt.info.sp.web.commands;

import uvt.info.sp.core.Book;

import java.util.Optional;

public class GetBookCommand implements Command<Optional<Book>> {
    private final Long id;

    public GetBookCommand(Long id) {
        this.id = id;
    }

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.booksService().findById(id);
    }
}
