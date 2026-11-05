package uvt.info.sp.web.components;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientComponent {
    private final SingletonComponent singletonComponent;
    private final TransientComponent transientComponent;

    @PostConstruct
    void logCreation() {
        log.info("ClientComponent::ClientComponent = {}", this);
        log.info("SingletonComponent = {}", singletonComponent);
        log.info("TransientComponent = {}", transientComponent);
    }

    public void operation() {
        log.info("ClientComponent::operation() called on {}", this);
        singletonComponent.operation();
        transientComponent.operation();
    }
}
