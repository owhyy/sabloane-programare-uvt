package uvt.info.sp;

public class AlignRight implements  AlignStrategy {
    @Override
    public void render(String text, Context context) {
        int leftPadding = Math.max(0, context.getLineWidth() - text.length());
        context.writeLine(" ".repeat(leftPadding) + text);
    }
}
