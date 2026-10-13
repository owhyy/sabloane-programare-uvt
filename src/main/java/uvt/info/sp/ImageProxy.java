package uvt.info.sp;

public class ImageProxy extends Element {
    private final String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    public void loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
    }

    @Override
    public void print() {
        loadImage();
        realImage.print();
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
