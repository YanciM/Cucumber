package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class HardCodedExamples {

    @Test
    public void sampleTest() {
        String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

        RequestSpecification preparedRequest = given().header("Authorization",
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjYzOTIwMDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjQzNTIwMSwidXNlcklkIjoiMjk1MCJ9.8k9-wiweG8F5Rq2WvPDag6Qb47XL-fI5j-VmOWSSxyU")
                .header("Content-Type", "application/json").queryParam("employee_id","21212A");

       Response response = preparedRequest.when().get("/getOneEmployee.php");

        System.out.println(response.asString());

    }

}
