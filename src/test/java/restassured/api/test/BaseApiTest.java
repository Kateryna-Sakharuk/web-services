package restassured.api.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import properties.PropertyReader;

public class BaseApiTest {
    protected PropertyReader propertyReader;
    @BeforeClass
    @Parameters("testData")
    public void setUp(String testData) {
        propertyReader =new PropertyReader(testData);
        RestAssured.baseURI = propertyReader.getProperty("base.uri");
        RestAssured.basePath = propertyReader.getProperty("base.path");
        RestAssured.defaultParser = Parser.JSON;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
