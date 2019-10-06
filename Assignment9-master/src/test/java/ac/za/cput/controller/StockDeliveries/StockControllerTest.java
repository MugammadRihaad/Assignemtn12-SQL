package ac.za.cput.controller.StockDeliveries;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.factory.StockDeliveries.FactoryStock;
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

public class StockControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/credLedger";


    public void testGetAccountantById() {
        Stock credLedger = restTemplate.getForObject(baseURL + "/credLedger/1", Stock.class);
        System.out.println(credLedger.getStockId());
        assertNotNull(credLedger);
    }



    @Test
    public void create() {
        Stock creditorsLedger = FactoryStock.getStock("appliances",
                400,8);


        creditorsLedger.setStockId("newId");

        ResponseEntity<Stock> postResponse = restTemplate.postForEntity(baseURL + "/new", creditorsLedger, Stock.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Stock creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Stock.class);

        restTemplate.put(baseURL + "/credLedger/" + id, creditorsLedger);
        Stock creditorsLedger1 = restTemplate.getForObject(baseURL + "/credLedger/" + id, Stock.class);
        assertNotNull(creditorsLedger);
    }

    @Test
    public void delete() {
        int id = 2;
        Stock creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Stock.class);
        assertNotNull(creditorsLedger);
        restTemplate.delete(baseURL + "/cakes/" + id);
        try {
            creditorsLedger = restTemplate.getForObject(baseURL + "/credLedger/" + id, Stock.class);
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