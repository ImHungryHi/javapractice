package code.interfacing;
import java.io.*;
import code.IO;
import java.util.*;

public interface FileSearch extends Closeable {
    List<IO.GrepInfo> grep(String haystack, String needle);

    //void close() throws IOException;  // Already implemented in Closeable
}
