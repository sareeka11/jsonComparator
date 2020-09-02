package com.practice;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class IComparatorImpl implements IComparator<String, String> {
    private JsonComparator jsonComparator;
    public IComparatorImpl(JsonComparator comparator) {
        this.jsonComparator = comparator;
    }

    @Override
    public boolean compare(String response1, String response2) {
        return jsonComparator.compare(response1, response2);
    }

    @Override
    public Wrapper<String, String> getData(File file1, File file2) throws IOException {
        String file1Content = FileUtils.readFileToString(file1, "UTF-8");
        String file2Content = FileUtils.readFileToString(file2, "UTF-8");
        Wrapper<String, String> wrapper = new Wrapper<>();
        wrapper.setX(file1Content);
        wrapper.setY(file2Content);
        return wrapper;
    }
}
