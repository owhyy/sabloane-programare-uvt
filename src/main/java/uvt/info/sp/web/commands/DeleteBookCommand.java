package uvt.info.sp.web.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteBookCommand implements Command<Boolean> {
    private final Long id;

    @Override
    public Boolean execute(CommandContext context) {
        return context.booksService().delete(id);
    }
}
