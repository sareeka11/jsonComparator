package com.practice;

import org.junit.Test;

public class JsonComparatorTest {

    @Test
    public void testCompare() {
        JsonComparator jsonComparator = new JsonComparator();
        String json1 = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 3,\n" +
                "        \"email\": \"emma.wong@reqres.in\",\n" +
                "        \"first_name\": \"Emma\",\n" +
                "        \"last_name\": \"Wong\",\n" +
                "        \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"\n" +
                "    },\n" +
                "    \"ad\": {\n" +
                "        \"company\": \"StatusCode Weekly\",\n" +
                "        \"url\": \"http://statuscode.org/\",\n" +
                "        \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
                "    }\n" +
                "}";

        String json2 = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 3,\n" +
                "        \"email\": \"emma.wong@reqres.in\",\n" +
                "        \"first_name\": \"Emma\",\n" +
                "        \"last_name\": \"Wong\",\n" +
                "        \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"\n" +
                "    },\n" +
                "    \"ad\": {\n" +
                "        \"company\": \"StatusCode Weekly\",\n" +
                "        \"url\": \"http://statuscode.org/\",\n" +
                "        \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
                "    }\n" +
                "}";

        assert jsonComparator.compare(json1, json2);

        String json3 = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 3,\n" +
                "        \"email\": \"emma.wong@reqres.in\",\n" +
                "        \"first_name\": \"Emma\",\n" +
                "        \"last_name\": \"Wong\",\n" +
                "        \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"\n" +
                "    },\n" +
                "    \"ad\": {\n" +
                "        \"company\": \"StatusCode Weekly1\",\n" +
                "        \"url\": \"http://statuscode.org/\",\n" +
                "        \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
                "    }\n" +
                "}";

        //difference in company field value
        assert !jsonComparator.compare(json1, json3);
    }
}
