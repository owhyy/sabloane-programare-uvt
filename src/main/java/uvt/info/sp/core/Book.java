package uvt.info.sp.core;

import java.util.List;

public class Book {
    private final String title;
    private final java.util.List<Author> authors;
    private final java.util.List<Element> elements;

    public Book(String title) {
        this.title = title;
        this.authors = new java.util.ArrayList<>();
        this.elements = new java.util.ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Element> getContent() {
        return elements;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addContent(Element element) {
        this.elements.add(element);
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
