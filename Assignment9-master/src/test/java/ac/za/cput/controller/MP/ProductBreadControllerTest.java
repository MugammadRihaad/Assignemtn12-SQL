package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.factory.MP.FactoryProductBread;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ProductBreadControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/cakes";


    public void testGetAccountantById() {
        ProductBread cakes = restTemplate.getForObject(baseURL + "/cakes/1", ProductBread.class);
        System.out.println(cakes.getProductBreadId());
        assertNotNull(cakes);
    }



    @Test
    public void create() {
        ProductBread bellStaff = FactoryProductBread.getProductBread("drinks",3000);

        bellStaff.setProductBreadId("newId");

        ResponseEntity<ProductBread> postResponse = restTemplate.postForEntity(baseURL + "/new", bellStaff, ProductBread.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        ProductBread prodCakes = restTemplate.getForObject(baseURL + "/cakes/" + id, ProductBread.class);

        restTemplate.put(baseURL + "/cakes/" + id, prodCakes);
        ProductBread cakes = restTemplate.getForObject(baseURL + "/cakes/" + id, ProductBread.class);
        assertNotNull(cakes);
    }

    @Test
    public void delete() {
        int id = 2;
        ProductBread prodCakes = restTemplate.getForObject(baseURL + "/cakes/" + id, ProductBread.class);
        assertNotNull(prodCakes);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            prodCakes = restTemplate.getForObject(baseURL + "/cakes/" + id, ProductBread.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);

        }
    }

    @Test
    public void read() {
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }



}