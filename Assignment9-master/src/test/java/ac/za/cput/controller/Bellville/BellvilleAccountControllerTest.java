package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BellvilleAccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/accountant";

    @Test
    public void a_create() {


        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(baseURL + "/create/account", null, String.class);
        System.out.println(result.getBody());


    }

    @Test
    public void b_findById() {

        //returns an object as a pojo thus getForObject
        BellvilleAccountant lookingFor = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleAccountant.class);

        assertNotNull(lookingFor);

    }

    @Test
    public void c_update() {

        BellvilleAccountant accountant = restTemplate.getForObject(baseURL + "/find/" + "new", BellvilleAccountant.class);
        accountant.setBellAccountID("newId-23");

        restTemplate.put(baseURL + "/update/" + "fas", accountant);

        BellvilleAccountant appointmentUpdated = restTemplate.getForObject(baseURL + "/update/" + "fas", BellvilleAccountant.class);

        assertNotNull(appointmentUpdated);

    }

    @Test
    public void e_delete() {

        BellvilleAccountant accountant = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleAccountant.class);
        assertNotNull(accountant);

        restTemplate.delete(baseURL + "/delete/" + "fas");

        try {
            accountant = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleAccountant.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
}