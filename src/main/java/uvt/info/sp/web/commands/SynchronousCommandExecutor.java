package uvt.info.sp.web.commands;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component("synchronousCommandExecutor")
public class SynchronousCommandExecutor implements CommandExecutor {
    @Override
    public <R> CompletableFuture<R> execute(
            Command<R> command,
            CommandContext context) {
        return CompletableFuture.completedFuture(command.execute(context));
    }
}
