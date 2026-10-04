package uvt.info.sp;

public class Paragraph implements Element {
    private final String title;

    public Paragraph(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + title);
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException("Cannot add elements to a Paragraph");
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove elements from a Paragraph");
    }

    @Override
    public Element get(int i) {
        return null;
    }
}
