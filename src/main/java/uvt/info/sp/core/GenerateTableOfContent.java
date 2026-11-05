package uvt.info.sp.core;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GenerateTableOfContent implements Visitor {
    private final TableOfContent tableOfContent = new TableOfContent();

    @Override
    public void visit(Book book) {
        for (Element element : book.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        tableOfContent.add(section);
        for (Element element : section.getElements()) {
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
}
