import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class PostAPITest {
    @Test
    public void testPost(){
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","Udayangi");
//        map.put("job","Quality Assurance");
//        System.out.println(map);
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
               post("/users").
               then().
               statusCode(201).
               log().all();


    }

}
