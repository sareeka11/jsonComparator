package com.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;

public class JsonComparator {
    public boolean compare(String json1, String json2) {
        if (json1.equals(json2) || (json1 == null && json2 == null))
            return true;
        ObjectNode objectNode1 = null;
        ObjectNode objectNode2 = null;
        try {
            objectNode1 = (ObjectNode) new ObjectMapper().readTree(json1);
            objectNode2 = (ObjectNode) new ObjectMapper().readTree(json2);
        } catch (JsonProcessingException e) {
            return false;
        }
        if (objectNode1.size() != objectNode2.size()) {
            //compare two object size
            return false;
        }
        if (objectNode1.elements() != null) {
            Iterator<String> nodes = objectNode1.fieldNames();
            while (nodes.hasNext()) {
                String key = nodes.next();
                JsonNode currentFieldValue = objectNode1.get(key);
                JsonNode currentFieldValueOfOtherObject = objectNode2.get(key);

                if (currentFieldValueOfOtherObject == null || !currentFieldValueOfOtherObject.equals(currentFieldValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
