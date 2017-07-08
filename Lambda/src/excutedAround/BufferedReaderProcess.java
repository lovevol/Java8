package excutedAround;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lh
 * on 2017/7/8.
 */
@FunctionalInterface//函数式接口
public interface BufferedReaderProcess {
    String process(BufferedReader b) throws IOException;
}
