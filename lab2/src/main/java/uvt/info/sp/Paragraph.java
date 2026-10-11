package uvt.info.sp;

public class Paragraph extends Element {
    private final String text;
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Paragraph text cannot be null");
        }
        this.text = text;
    }

    @Override
    public void print() {
        Context context = new Context();
        if (textAlignment == null) {
            context.writeLine(text);
            return;
        }
        textAlignment.render(text, context);
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

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.textAlignment = alignStrategy;
    }
}
