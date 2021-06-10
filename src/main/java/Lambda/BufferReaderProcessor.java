package Lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderProcessor {

    String process(BufferedReader br) throws IOException;
}
