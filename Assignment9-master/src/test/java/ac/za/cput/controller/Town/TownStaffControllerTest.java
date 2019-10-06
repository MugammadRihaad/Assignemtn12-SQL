package ac.za.cput.controller.Town;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
import ac.za.cput.factory.Town.FactoryTownStaff;
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
public class TownStaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/staff";

    @Ignore
    public void testGetAccountantById() {
        TownStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/1", TownStaff.class);
        System.out.println(bellStaff.getTnStaffId());
        assertNotNull(bellStaff);
    }



    @Test
    public void create() {
        TownStaff bellStaff = FactoryTownStaff.getTownStaff();
        bellStaff.setTnStaffId("newId");

        ResponseEntity<TownStaff> postResponse = restTemplate.postForEntity(baseURL + "/new", bellStaff, TownStaff.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        TownStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, TownStaff.class);

        restTemplate.put(baseURL + "/staff/" + id, bellvilleStaff);
        TownStaff bellStaff = restTemplate.getForObject(baseURL + "/staff/" + id, TownStaff.class);
        assertNotNull(bellStaff);
    }

    @Test
    public void delete() {
        int id = 2;
        TownStaff bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, TownStaff.class);
        assertNotNull(bellvilleStaff);
        restTemplate.delete(baseURL + "/staff/" + id);
        try {
            bellvilleStaff = restTemplate.getForObject(baseURL + "/staff/" + id, TownStaff.class);
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