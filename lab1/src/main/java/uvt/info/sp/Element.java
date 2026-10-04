package uvt.info.sp;

public abstract class Element {
    private Section parent;

    public Section getParent() {
        return parent;
    }

    void setParent(Section parent) {
        this.parent = parent;
    }

    public abstract void print();

    public abstract void add(Element e);
    public abstract void remove(Element e);
    public abstract Element get(int i);
}
