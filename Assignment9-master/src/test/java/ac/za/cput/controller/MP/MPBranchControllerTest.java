package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.factory.MP.FactoryMPBranch;
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

public class MPBranchControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/baker";


    public void testGetAccountantById() {
        MPBranch bellBaker = restTemplate.getForObject(baseURL + "/baker/1", MPBranch.class);
        System.out.println(bellBaker.getMpBrId());
        assertNotNull(bellBaker);
    }



    @Test
    public void create() {
        MPBranch bellBranch = FactoryMPBranch.getMPBranch();

        bellBranch.setMpBrId("newId");

        ResponseEntity<MPBranch> postResponse = restTemplate.postForEntity(baseURL + "/new", bellBranch, MPBranch.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MPBranch bellvilleBranch = restTemplate.getForObject(baseURL + "/baker/" + id, MPBranch.class);

        restTemplate.put(baseURL + "/baker/" + id, bellvilleBranch);
        MPBranch bellBranch = restTemplate.getForObject(baseURL + "/baker/" + id, MPBranch.class);
        assertNotNull(bellBranch);
    }

    @Test
    public void delete() {
        int id = 2;
        MPBranch bellvilleBranch = restTemplate.getForObject(baseURL + "/baker/" + id, MPBranch.class);
        assertNotNull(bellvilleBranch);
        restTemplate.delete(baseURL + "/baker/" + id);
        try {
            bellvilleBranch = restTemplate.getForObject(baseURL + "/baker/" + id, MPBranch.class);
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