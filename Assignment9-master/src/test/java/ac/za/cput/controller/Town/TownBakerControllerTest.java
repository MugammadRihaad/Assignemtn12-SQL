package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.factory.Town.FactoryTownBaker;
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
public class TownBakerControllerTest {



    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/baker";


    public void testGetAccountantById() {
        TownBaker bellBaker = restTemplate.getForObject(baseURL + "/baker/1", TownBaker.class);
        System.out.println(bellBaker.getTnBakerId());
        assertNotNull(bellBaker);
    }



    public void create() {
        TownBaker bellBaker = FactoryTownBaker.getTownBaker("Rihaad",5000
                );

        ResponseEntity<TownBaker> postResponse = restTemplate.postForEntity(baseURL + "/create", bellBaker, TownBaker.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        TownBaker bellBaker = restTemplate.getForObject(baseURL + "/baker/" + id, TownBaker.class);

        restTemplate.put(baseURL + "/baker/" + id, bellBaker);
        TownBaker bellAccounts = restTemplate.getForObject(baseURL + "/baker/" + id, TownBaker.class);
        assertNotNull(bellAccounts);
    }

    @Test
    public void delete() {
        int id = 2;
        TownBaker bellAccount = restTemplate.getForObject(baseURL + "/baker/" + id, TownBaker.class);
        assertNotNull(bellAccount);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellAccount = restTemplate.getForObject(baseURL + "/baker/" + id, TownBaker.class);
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