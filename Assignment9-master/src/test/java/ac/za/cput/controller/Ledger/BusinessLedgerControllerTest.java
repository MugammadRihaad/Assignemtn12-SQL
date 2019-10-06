package ac.za.cput.controller.Ledger;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
import ac.za.cput.factory.Ledger.FactoryBusinessLedger;
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
public class BusinessLedgerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/cakes";

    @Ignore
    public void testGetAccountantById() {
        BusinessLedger busLedger = restTemplate.getForObject(baseURL + "/busLedger/1", BusinessLedger.class);
        System.out.println(busLedger.getBusniessLId());
        assertNotNull(busLedger);
    }



    @Test
    public void create() {
        BusinessLedger baker = FactoryBusinessLedger.getBusinessLedger("Rihaad",2000);
        baker.setBusinessLId("newId");

        ResponseEntity<BusinessLedger> postResponse = restTemplate.postForEntity(baseURL + "/new", baker, BusinessLedger.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        BusinessLedger prodCakes = restTemplate.getForObject(baseURL + "/busLedger/" + id, BusinessLedger.class);

        restTemplate.put(baseURL + "/cakes/" + id, prodCakes);
        BusinessLedger cakes = restTemplate.getForObject(baseURL + "/busLedger/" + id, BusinessLedger.class);
        assertNotNull(cakes);
    }

    @Test
    public void delete() {
        int id = 2;
        BusinessLedger businessLedger = restTemplate.getForObject(baseURL + "/busLedger/" + id, BusinessLedger.class);
        assertNotNull(businessLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            businessLedger = restTemplate.getForObject(baseURL + "/busLedger/" + id, BusinessLedger.class);
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