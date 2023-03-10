import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class APIDemo1 {

    @Test
    void get_demo1() {

        given()
                .header("Content-Type", "application/josn")
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Michael", "Tobias", "Rachel", "Lindsay"))
                .log().all();


    }

    @Test
    void post_demo1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tarek");
        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject reg = new JSONObject(map);
        System.out.println(reg.toJSONString());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(reg.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void put_demo1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tarek");
        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject reg = new JSONObject(map);
        System.out.println(reg.toJSONString());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(reg.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    void patch_demo1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tarek");
        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject reg = new JSONObject(map);
        System.out.println(reg.toJSONString());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(reg.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    void delete_demo1(){
        when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();


    }

}