package uvt.info.sp.web.commands;

import lombok.RequiredArgsConstructor;
import uvt.info.sp.core.Book;

import java.util.Optional;

@RequiredArgsConstructor
public class GetBookCommand implements Command<Optional<Book>> {
    private final Long id;

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.booksService().findById(id);
    }
}
