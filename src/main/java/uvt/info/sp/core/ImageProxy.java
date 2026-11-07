package uvt.info.sp.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
public class ImageProxy extends Element {
    @NonNull
    private String url;
    @Transient
    @Getter(onMethod_ = @JsonIgnore)
    private Image realImage;

    public void loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
