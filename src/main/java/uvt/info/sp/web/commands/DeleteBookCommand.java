package uvt.info.sp.web.commands;

public class DeleteBookCommand implements Command<Boolean> {
    private final Long id;

    public DeleteBookCommand(Long id) {
        this.id = id;
    }

    @Override
    public Boolean execute(CommandContext context) {
        return context.booksService().delete(id);
    }
}
