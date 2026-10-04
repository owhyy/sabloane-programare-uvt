package uvt.info.sp;

public class Image extends Element {
    private final String s;

    public Image(String s) {
        this.s = s;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + s);
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException("Cannot add elements to an Image");
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove elements from an Image");
    }

    @Override
    public Element get(int i) {
        return null;
    }
}
