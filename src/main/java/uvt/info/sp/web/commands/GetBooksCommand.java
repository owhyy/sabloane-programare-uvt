package uvt.info.sp.web.commands;

import uvt.info.sp.core.Book;

import java.util.List;

public class GetBooksCommand implements Command<List<Book>> {
    @Override
    public List<Book> execute(CommandContext context) {
        return context.booksService().findAll();
    }
}
