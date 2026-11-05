package uvt.info.sp.core;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RenderContentVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        log.info("Book: {}", book.getTitle());
        log.info("Authors:");
        for (Author author : book.getAuthors()) {
            log.info("Author: {}", author.getName());
        }
        log.info("");
    }

    @Override
    public void visit(Section section) {
        log.info("Section: {}", section.getName());
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Paragraph paragraph) {
        Context context = new Context();
        String text = paragraph.getText();
        AlignStrategy textAlignment = paragraph.getTextAlignment();

        if (textAlignment == null) {
            context.writeLine(text);
            return;
        }
        textAlignment.render(text, context);
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.loadImage();
        visit(imageProxy.getRealImage());
    }

    @Override
    public void visit(Image image) {
        log.info("Image: {}", image.getUrl());
    }

    @Override
    public void visit(TableOfContent tableOfContent) {
        log.info("Table of Content:");
        for (Element element : tableOfContent.getSections()) {
            element.accept(this);
        }
    }
}
