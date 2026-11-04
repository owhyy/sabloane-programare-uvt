package uvt.info.sp.core;

public class RenderContentVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Authors:");
        for (Author author : book.getAuthors()) {
            System.out.println("Author: " + author.name());
        }
        System.out.println();
    }

    @Override
    public void visit(Section section) {
        System.out.println("Section: " + section.getName());
        for (Element element : section.getContent()) {
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
        visit(imageProxy.getImage());
    }

    @Override
    public void visit(Image image) {
        System.out.println("Image: " + image.getUrl());
    }

    public void visit(TableOfContent tableOfContent) {
        System.out.println("Table of Content:");
        for (Element element : tableOfContent.getSections()) {
            element.accept(this);
        }
    }
}
