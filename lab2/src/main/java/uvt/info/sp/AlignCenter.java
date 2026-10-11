package uvt.info.sp;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text, Context context) {
        int availablePadding = Math.max(0, context.getLineWidth() - text.length());
        int leftPadding = availablePadding / 2;
        int rightPadding = availablePadding - leftPadding;

        context.writeLine(
                " ".repeat(leftPadding) + text + " ".repeat(rightPadding)
        );
    }
}
