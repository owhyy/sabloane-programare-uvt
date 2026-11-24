package uvt.info.sp.web.observers;

import org.springframework.stereotype.Component;
import uvt.info.sp.core.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private Book latestBook;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(latestBook));
    }

    public void add(Book book) {
        this.latestBook = book;
        notifyObservers();
    }
}
