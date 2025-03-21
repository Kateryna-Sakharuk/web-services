package restassured.api.product;

import io.restassured.response.Response;
import models.product.Product;
import models.datagenerator.ProductGenerator;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import restassured.api.BaseApiTest;
import rest.RequestSpecForProduct;

public class ProductTest extends BaseApiTest {
    static final Logger logger = LogManager.getLogger(ProductTest.class);
    private RequestSpecForProduct productApi;
    private Product newProduct;
    private String productId;

    @BeforeClass
    public void setUpTestData() {
        productApi = new RequestSpecForProduct();
        newProduct = ProductGenerator.createNewProduct();
    }

    @Test
    public void createProductWithExistingId() {
        logger.info("Create a new product");
        Response response = productApi.postResource(newProduct);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Expected status 201 on create product");

        Product responseProduct = response.as(Product.class);
        productId = responseProduct.getId().toString();

        logger.info("Get a new product");
        Response getProduct = productApi.getResource(productId);
        Assert.assertEquals(getProduct.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code when retrieving product");

        logger.info("Creating a product with an existing ID");

        Response createExistingProduct =productApi.postResource(newProduct);
        Assert.assertEquals(createExistingProduct.getStatusCode(), HttpStatus.SC_CONFLICT, "Expected 409 status code when retrieving product");

        Response deleteProduct = productApi.deleteResource(productId);
        Assert.assertEquals(deleteProduct.getStatusCode(), HttpStatus.SC_NO_CONTENT, "Expected 409 status code when retrieving product");

        Response getDeletedProduct = productApi.getResource(productId);
        Assert.assertEquals(getDeletedProduct.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR, "Expected 200 status code when retrieving product");
    }
}
