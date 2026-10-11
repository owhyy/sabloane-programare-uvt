package uvt.info.sp;

public class Context {
    private final int lineWidth;

    public Context() {
        this(80);
    }

    public Context(int lineWidth) {
        if (lineWidth < 0) {
            throw new IllegalArgumentException("Line width cannot be negative");
        }
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void writeLine(String line) {
        System.out.println(line);
    }
}
