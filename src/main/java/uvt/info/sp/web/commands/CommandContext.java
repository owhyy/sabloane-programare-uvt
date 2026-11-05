package uvt.info.sp.web.commands;

import uvt.info.sp.web.services.BooksService;

public record CommandContext(BooksService booksService) {
}
