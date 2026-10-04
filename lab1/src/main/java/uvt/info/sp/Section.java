package uvt.info.sp;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
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
        elements.add(e);
    }

    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int i) {
        return elements.get(i);
    }
}
