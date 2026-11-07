package uvt.info.sp.web.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteBookCommand implements Command<Boolean> {
    private final Long id;

    @Override
    public Boolean execute(CommandContext context) {
        if (!context.booksRepository().existsById(id)) {
            return false;
        }
        context.booksRepository().deleteById(id);
        return true;
    }
}
