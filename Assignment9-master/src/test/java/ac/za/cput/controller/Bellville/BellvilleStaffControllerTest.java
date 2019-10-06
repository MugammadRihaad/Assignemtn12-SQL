package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
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

public class BellvilleStaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/staff";


    public void testGetAccountantById() {
        BellvilleStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/1", BellvilleStaff.class);
        System.out.println(bellStaff.getBellStaffId());
        assertNotNull(bellStaff);
    }



    @Test
    public void create() {
        BellvilleStaff staff = FactoryBellvilleStaff.getBellvilleStaff();
        staff.setBellStaffId("newId");

        ResponseEntity<BellvilleStaff> postResponse = restTemplate.postForEntity(baseURL + "/new", staff, BellvilleStaff.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        BellvilleStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, BellvilleStaff.class);

        restTemplate.put(baseURL + "/staff/" + id, bellvilleStaff);
        BellvilleStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/" + id, BellvilleStaff.class);
        assertNotNull(bellStaff);
    }

    @Test
    public void delete() {
        int id = 2;
        BellvilleStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, BellvilleStaff.class);
        assertNotNull(bellvilleStaff);
        restTemplate.delete(baseURL + "/staff/" + id);
        try {
            bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, BellvilleStaff.class);
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