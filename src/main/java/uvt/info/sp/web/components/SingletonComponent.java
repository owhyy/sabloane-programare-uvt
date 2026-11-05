package uvt.info.sp.web.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SingletonComponent {
    public SingletonComponent() {
        log.info("SingletonComponent::SingletonComponent = {}", this);
    }


    public void operation() {
        log.info("SingletonComponent::operation() called on {}", this);
    }
}
