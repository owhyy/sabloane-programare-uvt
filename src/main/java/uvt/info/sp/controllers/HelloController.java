package uvt.info.sp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uvt.info.sp.components.ClientComponent;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {
    private final ClientComponent clientComponent;

    @GetMapping("/")
    public String hello() {
        clientComponent.operation();
        return "Hello from " + clientComponent;
    }
}
