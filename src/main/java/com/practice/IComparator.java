package com.practice;

import java.io.File;
import java.io.IOException;

public interface IComparator<X, Y> {
    boolean compare(X x, Y y);
    Wrapper<X, Y> getData(File file1, File file2) throws IOException;
}
