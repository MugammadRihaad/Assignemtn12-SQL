package ac.za.cput.controller.Ledger;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.factory.Ledger.FactoryLedger;
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

public class LedgerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/credLedger";


    public void testGetAccountantById() {
        Ledger credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", Ledger.class);
        System.out.println(credLedger.getLedgerId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        Ledger creditorsLedger =  FactoryLedger.getLedger();


        creditorsLedger.setLedgerId("newId");

        ResponseEntity<Ledger> postResponse = restTemplate.postForEntity(baseURL + "/new", creditorsLedger, Ledger.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Ledger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Ledger.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        Ledger creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, Ledger.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        Ledger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Ledger.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Ledger.class);
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