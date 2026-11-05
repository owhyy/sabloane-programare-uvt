package uvt.info.sp.web.commands;

import uvt.info.sp.core.Book;

import java.util.Optional;

public class ReplaceBookCommand implements Command<Optional<Book>> {
    private final Long id;
    private final String title;

    public ReplaceBookCommand(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.booksService().replace(id, title);
    }
}
