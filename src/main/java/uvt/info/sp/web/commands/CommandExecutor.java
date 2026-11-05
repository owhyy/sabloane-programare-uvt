package uvt.info.sp.web.commands;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {
    <R> CompletableFuture<R> execute(Command<R> command, CommandContext context);
}
