import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import properties.PropertyReader;

public class BaseApiTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = PropertyReader.getProperty("base.uri");
        RestAssured.basePath = PropertyReader.getProperty("base.path");
        RestAssured.defaultParser = Parser.JSON;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
