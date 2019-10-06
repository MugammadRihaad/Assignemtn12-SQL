package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.factory.MP.FactoryMPDelivery;
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

public class MPDeliveryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/delivery";


    public void testGetAccountantById() {
        MPDelivery bellDeliv = restTemplate.getForObject(baseURL + "/delivery/1", MPDelivery.class);
        System.out.println(bellDeliv.getMpDeliveId());
        assertNotNull(bellDeliv);
    }



    @Test
    public void create() {
        MPDelivery bellDeliv = FactoryMPDelivery.getMPDelivery();
        bellDeliv.setMpDeliveId("newId");

        ResponseEntity<MPDelivery> postResponse = restTemplate.postForEntity(baseURL + "/new", bellDeliv, MPDelivery.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MPDelivery bellvilleBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, MPDelivery.class);

        restTemplate.put(baseURL + "/delivery/" + id, bellvilleBranch);
        MPDelivery bellBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, MPDelivery.class);
        assertNotNull(bellBranch);
    }

    @Test
    public void delete() {
        int id = 2;
        MPDelivery bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, MPDelivery.class);
        assertNotNull(bellvilleDeliv);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, MPDelivery.class);
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