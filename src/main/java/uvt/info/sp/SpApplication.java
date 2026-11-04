package uvt.info.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import uvt.info.sp.components.ClientComponent;
import uvt.info.sp.components.SingletonComponent;
import uvt.info.sp.components.TransientComponent;

@SpringBootApplication
public class SpApplication {

    static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(SpApplication.class, args);

		TransientComponent transientBean =
				context.getBean(TransientComponent.class);
		transientBean.operation();
		transientBean = context.getBean(TransientComponent.class);
		transientBean.operation();

		SingletonComponent singletonBean =
				context.getBean(SingletonComponent.class);
		singletonBean.operation();
		singletonBean = context.getBean(SingletonComponent.class);
		singletonBean.operation();

		ClientComponent c = context.getBean(ClientComponent.class);
		c.operation();
		c = (ClientComponent)context.getBean("clientComponent");
		c.operation();
    }

}
