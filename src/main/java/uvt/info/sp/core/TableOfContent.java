package uvt.info.sp.core;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TableOfContent extends Element {
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Section> sections = new ArrayList<>();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void add(Element e) {
        if (e instanceof Section section) {
            sections.add(section);
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
}
