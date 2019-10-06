package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.factory.Town.FactoryTownAccountant;
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
public class TownAccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/accountant";


    public void testGetAccountantById() {
        TownAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/1", TownAccountant.class);
        System.out.println(bellAccount.getTnAccountId());
        assertNotNull(bellAccount);
    }



    @Test
    public void create() {
        TownAccountant bellAccount = FactoryTownAccountant.getTownAccountant();

        bellAccount.setTnAccountId("newId");

        ResponseEntity<TownAccountant> postResponse = restTemplate.postForEntity(baseURL + "/new", bellAccount, TownAccountant.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        TownAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/" + id, TownAccountant.class);

        restTemplate.put(baseURL + "/students/" + id, bellAccount);
        TownAccountant bellAccounts = restTemplate.getForObject(baseURL + "/accountant/" + id, TownAccountant.class);
        assertNotNull(bellAccounts);
    }

    @Test
    public void delete() {
        int id = 2;
        TownAccountant bellAccount = restTemplate.getForObject(baseURL + "/accountant/" + id, TownAccountant.class);
        assertNotNull(bellAccount);
        restTemplate.delete(baseURL + "/accountant/" + id);
        try {
            bellAccount = restTemplate.getForObject(baseURL + "/students/" + id, TownAccountant.class);
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