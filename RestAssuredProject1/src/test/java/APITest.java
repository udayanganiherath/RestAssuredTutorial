import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
 import static org.hamcrest.Matchers.*;
public class APITest {

    @Test
    void test1(){
        Response response =get("https://reqres.in/api/users?page=2");
        System.out.println("Response :"+ response.asString());
        System.out.println("Status code:"+response.getStatusCode());
        System.out.println("Body:"+response.getBody().asString());
        System.out.println("Time taken:"+response.getTime());
        System.out.println("Header:"+response.getHeader("content-type"));

        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode,200);
    }
    @Test
    void test2(){
        given().
            get("https://reqres.in/api/users?page=2").
        then().
            statusCode(200).
            body("data[1].id",equalTo(8)).
//        .log().all().
            body("data.first_name",hasItems("George","Rachel"));
    }
}
