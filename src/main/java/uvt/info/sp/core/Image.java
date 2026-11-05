package uvt.info.sp.core;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class Image extends Element {
    private String url;

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("Interrupted while loading image '{}'", url, e);
            Thread.currentThread().interrupt();
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
