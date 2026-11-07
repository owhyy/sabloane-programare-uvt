package uvt.info.sp.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Paragraph extends Element {
    private String text;
    @Transient
    @Getter(onMethod_ = @JsonIgnore)
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Paragraph text cannot be null");
        }
        this.text = text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException("Cannot add elements to a Paragraph");
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove elements from a Paragraph");
    }

    @Override
    public Element get(int i) {
        return null;
    }

}
