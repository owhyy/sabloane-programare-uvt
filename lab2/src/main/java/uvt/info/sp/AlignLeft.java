package uvt.info.sp;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(String text, Context context) {
        context.writeLine(text);
    }
}
