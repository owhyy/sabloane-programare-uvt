package uvt.info.sp.web.components;

import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {
    public SingletonComponent() {
        System.out.println("SingletonComponent::SingletonComponent = " + this);
    }


    public void operation() {
        System.out.println("SingletonComponent::operation() called on " + this);
    }
}
