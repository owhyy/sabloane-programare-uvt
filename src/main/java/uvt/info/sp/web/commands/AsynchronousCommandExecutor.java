package uvt.info.sp.web.commands;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component("asynchronousCommandExecutor")
public class AsynchronousCommandExecutor implements CommandExecutor {
    @Override
    public <R> CompletableFuture<R> execute(
            Command<R> command,
            CommandContext context) {
        return CompletableFuture.supplyAsync(() -> command.execute(context));
    }
}
