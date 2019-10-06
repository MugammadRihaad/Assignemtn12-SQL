package ac.za.cput.controller.Office;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.factory.HeadOffice.FactoryHeadOffice;
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
public class HeadOfficeControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/office";


    public void testGetAccountantById() {
        HeadOffice credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", HeadOffice.class);
        System.out.println(credLedger.getOfficeId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        HeadOffice creditorsLedger =  FactoryHeadOffice.getHeadOffice();



        creditorsLedger.setOfficeId("newId");

        ResponseEntity<HeadOffice> postResponse = restTemplate.postForEntity(baseURL + "/new", creditorsLedger, HeadOffice.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        HeadOffice creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, HeadOffice.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        HeadOffice creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, HeadOffice.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        HeadOffice creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, HeadOffice.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, HeadOffice.class);
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