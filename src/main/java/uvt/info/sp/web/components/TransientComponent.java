package uvt.info.sp.web.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class TransientComponent {
    public TransientComponent() {
        log.info("TransientComponent::TransientComponent = {}", this);
    }


    public void operation() {
        log.info("TransientComponent::operation() called on {}", this);
    }
}
