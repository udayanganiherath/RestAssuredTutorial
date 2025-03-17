import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class putPatchDeleteTest {
    @Test
    public void testPut(){

        JSONObject request = new JSONObject();
        request.put("name","Udayangi");
        request.put("job","Quality Assurance");
        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();
        request.put("name","Udayangi");
        request.put("job","Quality Assurance");
        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("api/users/2").
                then().
                statusCode(200).
                log().all();
    }
@Test
    public void testDelete(){


        baseURI = "https://reqres.in";

                when().
                delete("api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}


