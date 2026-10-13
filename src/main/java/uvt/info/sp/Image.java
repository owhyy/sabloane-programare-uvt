package uvt.info.sp;

import java.util.concurrent.TimeUnit;

public class Image extends Element {
    private final String url;

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
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
