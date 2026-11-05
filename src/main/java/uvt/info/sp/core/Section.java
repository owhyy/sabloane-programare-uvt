package uvt.info.sp.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Section extends Element {
    private String name;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Element> elements = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
