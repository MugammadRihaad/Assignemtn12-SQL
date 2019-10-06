package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.factory.MP.FactoryMPBaker;
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
public class MPBakerControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/baker";


    public void testGetAccountantById() {
        MPBaker bellBaker = restTemplate.getForObject(baseURL + "/baker/1", MPBaker.class);
        System.out.println(bellBaker.getMpBakerId());
        assertNotNull(bellBaker);
    }



    @Test
    public void create() {
        MPBaker bellBaker = FactoryMPBaker.getMPBaker("Rihaad",5000);

        bellBaker.setMpBakerId("newId");

        ResponseEntity<MPBaker> postResponse = restTemplate.postForEntity(baseURL + "/new", bellBaker, MPBaker.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MPBaker bellBaker = restTemplate.getForObject(baseURL + "/baker/" + id, MPBaker.class);

        restTemplate.put(baseURL + "/baker/" + id, bellBaker);
        MPBaker bellAccounts = restTemplate.getForObject(baseURL + "/baker/" + id, MPBaker.class);
        assertNotNull(bellAccounts);
    }

    @Test
    public void delete() {
        int id = 2;
        MPBaker bellAccount = restTemplate.getForObject(baseURL + "/baker/" + id, MPBaker.class);
        assertNotNull(bellAccount);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellAccount = restTemplate.getForObject(baseURL + "/baker/" + id, MPBaker.class);
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