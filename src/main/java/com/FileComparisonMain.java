package com;

import com.practice.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FileComparisonMain {

    private static void process(File file1, File file2) throws IOException {
        JsonComparator jsonComparator = new JsonComparator();
        IComparator<String, String> iComparator = new IComparatorImpl(jsonComparator);
        Wrapper<String, String> data = iComparator.getData(file1, file2);
        HttpCommunicator httpCommunicator = new HttpCommunicator();

        List<String> list1 = Arrays.asList(data.getX().split("\n"));
        List<String> list2 = Arrays.asList(data.getY().split("\n"));

        //execute in parallel
        IntStream.range(0, list1.size()).parallel().forEach(i -> {
            String endPointFirst = list1.get(i);
            String endPointSecond = list2.get(i);
            String response1 = null;
            String response2 = null;
            boolean skip = false;
            try {
                //get response
                response1 = httpCommunicator.getResponseBody(preProcessStringEndpoint(endPointFirst));
                response2 = httpCommunicator.getResponseBody(preProcessStringEndpoint(endPointSecond));
            } catch (Exception e) {
                System.out.println("Unable to get response of index-" + i + "endpoint, skipping step");
                skip = true;
            }
            //skip false means we got both response, thus compare it
            if(!skip) {
                boolean result = iComparator.compare(response1, response2);
                if(result) {
                    System.out.println(preProcessStringEndpoint(endPointFirst) + " equals " + preProcessStringEndpoint(endPointSecond));
                } else {
                    System.out.println(preProcessStringEndpoint(endPointFirst) + " not equals " +  preProcessStringEndpoint(endPointSecond));
                }
            }

        });
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File ("src/main/resources/file1.txt");
        File file2 = new File ("src/main/resources/file2.txt");
        process(file1, file2);
    }

    private static String preProcessStringEndpoint(String endPoint) {
        return endPoint.replace("\r", "");
    }
}
