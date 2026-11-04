package uvt.info.sp.core;

public class BookStatistics implements Visitor {
    private int numberOfSections;
    private int numberOfParagraphs;
    private int numberOfImages;

    public BookStatistics() {
        this.numberOfSections = 0;
        this.numberOfParagraphs = 0;
        this.numberOfImages = 0;
    }

    @Override
    public void visit(Book book) {
        for (Element element : book.getContent()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        numberOfSections++;
        for (Element element : section.getContent()) {
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

    public int getNumberOfParagraphs() {
        return numberOfParagraphs;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getNumberOfSections() {
        return numberOfSections;
    }

    public void print() {
        System.out.println("Number of sections: " + numberOfSections);
        System.out.println("Number of paragraphs: " + numberOfParagraphs);
        System.out.println("Number of images: " + numberOfImages);
    }
}
