package uvt.info.sp.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Getter(onMethod_ = @JsonIgnore)
    private Section parent;

    void setParent(Section parent) {
        this.parent = parent;
    }

    public abstract void accept(Visitor visitor);

    public abstract void add(Element e);

    public abstract void remove(Element e);

    public abstract Element get(int i);
}
