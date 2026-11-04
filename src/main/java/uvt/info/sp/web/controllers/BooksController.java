package uvt.info.sp.web.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BooksController {

    @GetMapping("/books")
    public String getBooks() {
        return "All books";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable String id) {
        return "Book with id " + id;
    }

    @PostMapping("/books")
    public String createBook(@RequestBody(required = false) String book) {
        return "Book created";
    }

    @PutMapping("/books/{id}")
    public String replaceBook(
            @PathVariable String id,
            @RequestBody(required = false) String book) {
        return "Book with id " + id + " replaced";
    }

    @DeleteMapping({"/book/{id}", "/books/{id}"})
    public String deleteBook(@PathVariable String id) {
        return "Book with id " + id + " deleted";
    }
}
