package uvt.info.sp;

public interface Visitor {
    void visit(Book book);

    void visit(Section section);

    void visit(Paragraph paragraph);

    void visit(ImageProxy imageProxy);

    void visit(Image image);

    void visit(TableOfContent tableOfContent);
}
