package uvt.info.sp.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@NoArgsConstructor
@Slf4j
public class BookStatistics implements Visitor {
    private int numberOfSections;
    private int numberOfParagraphs;
    private int numberOfImages;

    @Override
    public void visit(Book book) {
        for (Element element : book.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        numberOfSections++;
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Paragraph paragraph) {
        numberOfParagraphs++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        numberOfImages++;
    }

    @Override
    public void visit(Image image) {
        numberOfImages++;
    }

    @Override
    public void visit(TableOfContent tableOfContent) {
        for (Section section : tableOfContent.getSections()) {
            section.accept(this);
        }
    }

    public void print() {
        log.info("Number of sections: {}", numberOfSections);
        log.info("Number of paragraphs: {}", numberOfParagraphs);
        log.info("Number of images: {}", numberOfImages);
    }
}
