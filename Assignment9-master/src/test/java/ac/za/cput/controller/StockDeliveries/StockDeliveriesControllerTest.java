package ac.za.cput.controller.StockDeliveries;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.factory.StockDeliveries.FactoryStockDeliveries;
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

public class StockDeliveriesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/credLedger";


    public void testGetAccountantById() {
        StockDeliveries credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", StockDeliveries.class);
        System.out.println(credLedger.getDelId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        StockDeliveries creditorsLedger =  FactoryStockDeliveries.getStockDeliveries("w35df","26dtgs");


        creditorsLedger.setStockdelId("newId");

        ResponseEntity<StockDeliveries> postResponse = restTemplate.postForEntity(baseURL + "/new", creditorsLedger, StockDeliveries.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        StockDeliveries creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, StockDeliveries.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        StockDeliveries creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, StockDeliveries.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        StockDeliveries creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, StockDeliveries.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, StockDeliveries.class);
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