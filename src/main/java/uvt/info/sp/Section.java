package uvt.info.sp;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    private final String name;
    private final List<Element> elements = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void add(Element e) {
        if (e == null) {
            throw new IllegalArgumentException("An element cannot be null");
        }
        if (e.getParent() != null) {
            throw new IllegalArgumentException("Element already belongs to a section");
        }
        elements.add(e);
        e.setParent(this);
    }

    @Override
    public void remove(Element e) {
        if (elements.remove(e)) {
            e.setParent(null);
        }
    }

    @Override
    public Element get(int i) {
        return elements.get(i);
    }
}
