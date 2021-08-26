package org.example;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class TestClass {
    @Test
    public void minNumberOfJokes() {
        List<Value> json = given().
                when().
                get("http://api.icndb.com/jokes/").
                then().
                statusCode(200).
                extract().
                jsonPath().
                getList("value", Value.class);
        Map<Long, String> collection = new HashMap();
        for (Value value : json) {
            if (value.getId() >= 0) {
                collection.put(value.getId(), value.getCategories().toString());
            }
        }
        String minCategoriesJokes = collection.values().stream().min(Comparator.comparing(collection::containsValue)).get();
        StringBuilder changingALine = new StringBuilder(minCategoriesJokes);
        changingALine.deleteCharAt(0);
        changingALine.deleteCharAt(8);
        Assert.assertEquals(changingALine.toString(), "explicit");
    }
}