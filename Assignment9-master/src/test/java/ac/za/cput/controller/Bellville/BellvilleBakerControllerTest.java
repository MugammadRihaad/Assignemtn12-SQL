package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
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
public class BellvilleBakerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/baker";

    @Test
    public void a_create() {

        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",4000);
        baker.setBellBakerID("newId");

        ResponseEntity<bellvilleBaker> postResponse = restTemplate.postForEntity(baseURL + "/new/", baker, bellvilleBaker.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        //returns an object as a pojo thus getForObject
        bellvilleBaker lookingFor = restTemplate.getForObject(baseURL + "/find/" , bellvilleBaker.class);

        assertNotNull(lookingFor);

    }

    @Test
    public void c_update() {

        bellvilleBaker baker = restTemplate.getForObject(baseURL + "/find/" + "new", bellvilleBaker.class);
        baker.setBellBakerID("newId-23");

        restTemplate.put(baseURL + "/update/" + "fas", baker);

        bellvilleBaker bakerUpdated = restTemplate.getForObject(baseURL + "/update/" + "fas", bellvilleBaker.class);

        assertNotNull(bakerUpdated);

    }

    @Test
    public void e_delete() {

        bellvilleBaker baker = restTemplate.getForObject(baseURL + "/find/" + "fas", bellvilleBaker.class);
        assertNotNull(baker);

        restTemplate.delete(baseURL + "/delete/" + "fas");

        try {
            baker = restTemplate.getForObject(baseURL + "/find/" + "fas", bellvilleBaker.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(baseURL + "/getall", String.class);
        System.out.println(result.getBody());


    }
}