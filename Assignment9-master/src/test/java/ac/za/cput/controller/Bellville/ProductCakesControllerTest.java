package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.factory.Bellville.FactoryProductCakes;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ProductCakesControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/administrator";


    @Test
    public void create() {
        ProductCakes cake = FactoryProductCakes.getProductCakes("Chocolate",200);
        cake.setProductCakeId("newId");

        ResponseEntity<ProductCakes> postResponse = restTemplate.postForEntity(baseURL + "/new", cake, ProductCakes.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void update() {
        ProductCakes cakes = restTemplate.getForObject(baseURL + "/find/" + "newId", ProductCakes.class);
        cakes.setProductCakeId("newId");
        restTemplate.put(baseURL + "/update/" + "newId", cakes);
        ProductCakes updatedAdministrator = restTemplate.getForObject(baseURL + "/update/" + "newId", ProductCakes.class);
        assertNotNull(cakes);
        System.out.println(cakes);
    }

    @Test
    public void delete() {
        int id = 2;
        ProductCakes prodCakes = restTemplate.getForObject(baseURL + "/cakes/" + "newId", ProductCakes.class);
        assertNotNull(prodCakes);
        restTemplate.delete(baseURL + "/cakes/" + "newId");
        try {
            prodCakes = restTemplate.getForObject(baseURL + "/cakes/" + "newId", ProductCakes.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);

        }
    }

    @Test
    public void b_findById() {

        ProductCakes cakes = restTemplate.getForObject(baseURL + "/find/" + "newId", ProductCakes.class);
        assertNotNull(cakes);
        System.out.println(cakes.getProductCakeId());

    }

    @Test
    public void read() {
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").exchange(baseURL + "/getall", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }


}