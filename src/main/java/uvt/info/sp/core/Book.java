package uvt.info.sp.core;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany
    private final List<Author> authors = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private final List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) {
        this.elements.add(element);
    }
}
