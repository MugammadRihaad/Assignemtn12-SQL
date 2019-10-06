package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.factory.Town.FactoryTownDelivery;
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

public class TownDeliveryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/delivery";


    public void testGetAccountantById() {
        TownDelivery bellDeliv = restTemplate.getForObject(baseURL + "/delivery/1", TownDelivery.class);
        System.out.println(bellDeliv.getTnDeliveId());
        assertNotNull(bellDeliv);
    }



    @Test
    public void create() {
        TownDelivery bellDeliv = FactoryTownDelivery.getTownDelivery();
        bellDeliv.setTnDeliveId("newId");

        ResponseEntity<TownDelivery> postResponse = restTemplate.postForEntity(baseURL + "/new", bellDeliv, TownDelivery.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        TownDelivery bellvilleBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, TownDelivery.class);

        restTemplate.put(baseURL + "/delivery/" + id, bellvilleBranch);
        TownDelivery bellBranch = restTemplate.getForObject(baseURL + "/delivery/" + id, TownDelivery.class);
        assertNotNull(bellBranch);
    }

    @Test
    public void delete() {
        int id = 2;
        TownDelivery bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, TownDelivery.class);
        assertNotNull(bellvilleDeliv);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellvilleDeliv = restTemplate.getForObject(baseURL + "/delivery/" + id, TownDelivery.class);
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