package uvt.info.sp;

public class Book {
    private final String title;
    private final java.util.List<Author> authors;
    private final java.util.List<Element> elements;

    public Book(String title) {
        this.title = title;
        this.authors = new java.util.ArrayList<>();
        this.elements = new java.util.ArrayList<>();
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addContent(Element element) {
        this.elements.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();
        for (Element element : elements) {
            element.print();
        }
    }
}
