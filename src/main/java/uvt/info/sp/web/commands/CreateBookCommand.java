package uvt.info.sp.web.commands;

import uvt.info.sp.core.Book;

public class CreateBookCommand implements Command<Book> {
    private final String title;

    public CreateBookCommand(String title) {
        this.title = title;
    }

    @Override
    public Book execute(CommandContext context) {
        return context.booksService().create(title);
    }
}
