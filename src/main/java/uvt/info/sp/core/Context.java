package uvt.info.sp.core;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
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

    public void writeLine(String line) {
        log.info(line);
    }
}
