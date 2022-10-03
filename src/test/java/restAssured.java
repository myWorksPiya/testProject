import static  io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;


import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class restAssured {

   @Test
    public static void restAssured(){
//     get request
       given()
           .header("Content-type","application/json")
           .get("https://reqres.in/api/users?page=2")
       .then()
           .statusCode(200)
           .body("data.id[1]",equalTo(8))
           .body("data.first_name",hasItems("Michael","Lindsay"))
           .log().all();

//     post request

       JSONObject req = new JSONObject();
       req.put("name","Priya");
       req.put("job","Programmer");
       given()
            .header("Content-type","application/json")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(req.toJSONString())
       .when()
            .header("Content-type","application/json")
            .post("https://reqres.in/api/users")
       .then()
            .statusCode(201)
            .log().all();
//     put request
       req = new JSONObject();
       req.put("name","Priya");
       req.put("job","Dentist");
       given()
               .header("Content-type","application/json")
               .contentType(ContentType.JSON).accept(ContentType.JSON)
               .body(req.toJSONString())
               .when()
               .header("Content-type","application/json")
               .put("https://reqres.in/api/users/2")
               .then()
               .statusCode(200)
               .log().all();

//     patch request
       req = new JSONObject();
       req.put("name","Priya");
       req.put("job","Dentist");
       given()
               .header("Content-type","application/json")
               .contentType(ContentType.JSON).accept(ContentType.JSON)
               .body(req.toJSONString())
               .when()
               .header("Content-type","application/json")
               .patch("https://reqres.in/api/users/2")
               .then()
               .statusCode(200)
               .log().all();
//     delete request
       given()
               .header("Content-type","application/json")
               .contentType(ContentType.JSON).accept(ContentType.JSON)
               .when()
               .header("Content-type","application/json")
               .put("https://reqres.in/api/users/2")
               .then()
               .statusCode(200)
               .log().all();
//
    }
}
