package uvt.info.sp;

public class GenerateTableOfContent implements Visitor {
    private final TableOfContent tableOfContent;

    public GenerateTableOfContent() {
        this.tableOfContent = new TableOfContent();
    }

    @Override
    public void visit(Book book) {
        for (Element element : book.getContent()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        tableOfContent.add(section);
        for (Element element : section.getContent()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Paragraph paragraph) {
        // Do nothing for paragraphs
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        // Do nothing for images
    }

    @Override
    public void visit(Image image) {
        // Do nothing for images
    }

    @Override
    public void visit(TableOfContent tableOfContent) {
        for (Section section : tableOfContent.getSections()) {
            section.accept(this);
        }
    }

    public TableOfContent getTableOfContent() {
        return tableOfContent;
    }
}
