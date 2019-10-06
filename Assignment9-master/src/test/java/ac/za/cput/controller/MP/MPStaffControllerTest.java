package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.factory.MP.FactoryMPStaff;
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
public class MPStaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/staff";


    public void testGetAccountantById() {
        MPStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/1", MPStaff.class);
        System.out.println(bellStaff.getMpStaffId());
        assertNotNull(bellStaff);
    }



    @Test
    public void create() {
        MPStaff bellStaff = FactoryMPStaff.getMPStaff();
        bellStaff.setMpBakerId("newId");

        ResponseEntity<MPStaff> postResponse = restTemplate.postForEntity(baseURL + "/new", bellStaff, MPStaff.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MPStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, MPStaff.class);

        restTemplate.put(baseURL + "/staff/" + id, bellvilleStaff);
        MPStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/" + id, MPStaff.class);
        assertNotNull(bellStaff);
    }

    @Test
    public void delete() {
        int id = 2;
        MPStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, MPStaff.class);
        assertNotNull(bellvilleStaff);
        restTemplate.delete(baseURL + "/staff/" + id);
        try {
            bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, MPStaff.class);
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