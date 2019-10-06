package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.factory.Bellville.FactoryBellvilleDelivery;
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

public class BellvilleDeliveryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/delivery";


    public void testGetAccountantById() {
        BellvilleDelivery bellDeliv = restTemplate.getForObject(baseURL + "/delivery/1", BellvilleDelivery.class);
        System.out.println(bellDeliv.getBellDeliveId());
        assertNotNull(bellDeliv);
    }



    @Test
    public void create() {
        BellvilleDelivery deliv = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliv.setBellDeliveId("newId");

        ResponseEntity<BellvilleDelivery> postResponse = restTemplate.postForEntity(baseURL + "/new", deliv, BellvilleDelivery.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        BellvilleDelivery bellvilleBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, BellvilleDelivery.class);

        restTemplate.put(baseURL + "/delivery/" + id, bellvilleBranch);
        BellvilleDelivery bellBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, BellvilleDelivery.class);
        assertNotNull(bellBranch);
    }

    @Test
    public void delete() {
        int id = 2;
        BellvilleDelivery bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, BellvilleDelivery.class);
        assertNotNull(bellvilleDeliv);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, BellvilleDelivery.class);
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