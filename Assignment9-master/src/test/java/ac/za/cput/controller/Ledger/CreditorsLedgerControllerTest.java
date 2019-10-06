package ac.za.cput.controller.Ledger;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.factory.Ledger.FactoryCreditorsLedger;
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

public class CreditorsLedgerControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/credLedger";


    public void testGetAccountantById() {
        CreditorsLedger credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", CreditorsLedger.class);
        System.out.println(credLedger.getCreditorsLId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        CreditorsLedger baker = FactoryCreditorsLedger.getCreditorsLedger("Makro",20);
        baker.setCreditorsLId("newId");

        ResponseEntity<CreditorsLedger> postResponse = restTemplate.postForEntity(baseURL + "/new", baker, CreditorsLedger.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        CreditorsLedger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, CreditorsLedger.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        CreditorsLedger creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, CreditorsLedger.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        CreditorsLedger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, CreditorsLedger.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, CreditorsLedger.class);
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