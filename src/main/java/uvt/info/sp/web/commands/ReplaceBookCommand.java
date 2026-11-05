package uvt.info.sp.web.commands;

import lombok.RequiredArgsConstructor;
import uvt.info.sp.core.Book;

import java.util.Optional;

@RequiredArgsConstructor
public class ReplaceBookCommand implements Command<Optional<Book>> {
    private final Long id;
    private final String title;

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.booksService().replace(id, title);
    }
}
