package uvt.info.sp.core;

import java.util.List;

public class TableOfContent extends Element {
    private final List<Section> sections;

    public TableOfContent() {
        this.sections = new java.util.ArrayList<>();
    }

    public TableOfContent(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void add(Element e) {
        if (e instanceof Section) {
            sections.add((Section) e);
        } else {
            throw new IllegalArgumentException("Only Section elements can be added to TableOfContent");
        }
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove elements from TableOfContent");
    }

    @Override
    public Element get(int i) {
        return null;
    }

    public List<Section> getSections() {
        return sections;
    }
}
