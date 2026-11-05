package uvt.info.sp.web.commands;

public interface Command<R> {
    R execute(CommandContext context);
}
