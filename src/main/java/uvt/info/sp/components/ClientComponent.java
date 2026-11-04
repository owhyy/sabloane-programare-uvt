package uvt.info.sp.components;

import org.springframework.stereotype.Component;

@Component
public class ClientComponent {
    private final SingletonComponent singletonComponent;
    private final TransientComponent transientComponent;

    public ClientComponent(SingletonComponent singletonComponent, TransientComponent transientComponent) {
        this.singletonComponent = singletonComponent;
        this.transientComponent = transientComponent;
        System.out.println("ClientComponent::ClientComponent = " + this);
        System.out.println("SingletonComponent = " + singletonComponent);
        System.out.println("TransientComponent = " + transientComponent);
    }

    public void operation() {
        System.out.println("ClientComponent::operation() called on " + this);
        singletonComponent.operation();
        transientComponent.operation();
    }
}
