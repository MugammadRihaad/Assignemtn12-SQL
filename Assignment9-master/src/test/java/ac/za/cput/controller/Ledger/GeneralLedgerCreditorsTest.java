package ac.za.cput.controller.Ledger;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.factory.Ledger.FactoryGeneralLedger;
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

public class GeneralLedgerCreditorsTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/credLedger";


    public void testGetAccountantById() {
        GeneralLedger credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", GeneralLedger.class);
        System.out.println(credLedger.getGeneralLId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        GeneralLedger creditorsLedger =  FactoryGeneralLedger.getGeneralLedger("09/2/2013", 200, 1200);


        creditorsLedger.setGeneralLId("newId");

        ResponseEntity<GeneralLedger> postResponse = restTemplate.postForEntity(baseURL + "/new", creditorsLedger, GeneralLedger.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        GeneralLedger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, GeneralLedger.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        GeneralLedger creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, GeneralLedger.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        GeneralLedger creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, GeneralLedger.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, GeneralLedger.class);
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