package uvt.info.sp.core;

public class Main {
    static void start() {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);

        Section subcap1 = new Section("Capitolul 1.1");
        Paragraph p5 = new Paragraph("Paragraph 5");
        subcap1.add(p5);
        ImageProxy img = new ImageProxy("Image 1");
        subcap1.add(img);
        cap1.add(subcap1);

        Book book = new Book("Book 1");
        book.addContent(cap1);

        BookStatistics stats = new BookStatistics();
        stats.visit(book);
        stats.print();

        System.out.println();

        var toc = new GenerateTableOfContent();
        toc.visit(book);
        var render = new RenderContentVisitor();
        toc.getTableOfContent().accept(render);
    }

    static void main() {
        start();
    }
}
