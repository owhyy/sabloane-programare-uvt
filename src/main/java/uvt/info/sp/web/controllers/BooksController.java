package uvt.info.sp.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import uvt.info.sp.core.Book;
import uvt.info.sp.web.commands.*;
import uvt.info.sp.web.services.BooksService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping
public class BooksController {
    private final CommandContext commandContext;
    private final CommandExecutor commandExecutor;

    public BooksController(
            BooksService booksService,
            @Qualifier("asynchronousCommandExecutor") CommandExecutor commandExecutor) {
        this.commandContext = new CommandContext(booksService);
        this.commandExecutor = commandExecutor;
    }

    @GetMapping("/books")
    public CompletableFuture<List<Book>> getBooks() {
        return commandExecutor.execute(new GetBooksCommand(), commandContext);
    }

    @GetMapping("/books/{id}")
    public CompletableFuture<ResponseEntity<Book>> getBook(@PathVariable Long id) {
        return commandExecutor.execute(new GetBookCommand(id), commandContext)
                .thenApply(book -> book
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @PostMapping("/books")
    public CompletableFuture<Book> createBook(@RequestBody String title) {
        return commandExecutor.execute(new CreateBookCommand(title), commandContext);
    }

    @PutMapping("/books/{id}")
    public CompletableFuture<ResponseEntity<Book>> replaceBook(
            @PathVariable Long id,
            @RequestBody String title) {
        return commandExecutor.execute(new ReplaceBookCommand(id, title), commandContext)
                .thenApply(book -> book
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/books/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteBook(@PathVariable Long id) {
        return commandExecutor.execute(new DeleteBookCommand(id), commandContext)
                .thenApply(deleted -> deleted
                        ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build());
    }
}
