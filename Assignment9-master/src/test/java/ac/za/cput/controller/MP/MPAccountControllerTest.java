package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.factory.MP.FactoryMPAccountant;
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
public class MPAccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/accountant";


    public void testGetAccountantById() {
        MPAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/1", MPAccountant.class);
        System.out.println(bellAccount.getMpAccountId());
        assertNotNull(bellAccount);
    }



    @Test
    public void create() {
        MPAccountant bellAccount = FactoryMPAccountant.getMPAccountant();

        bellAccount.setMpAccountId("newId");

        ResponseEntity<MPAccountant> postResponse = restTemplate.postForEntity(baseURL + "/new", bellAccount, MPAccountant.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MPAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/" + id, MPAccountant.class);

        restTemplate.put(baseURL + "/students/" + id, bellAccount);
        MPAccountant bellAccounts = restTemplate.getForObject(baseURL + "/accountant/" + id, MPAccountant.class);
        assertNotNull(bellAccounts);
    }

    @Test
    public void delete() {
        int id = 2;
        MPAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/" + id, MPAccountant.class);
        assertNotNull(bellAccount);
        restTemplate.delete(baseURL + "/accountant/" + id);
        try {
            bellAccount = restTemplate.getForObject(baseURL + "/students/" + id, MPAccountant.class);
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