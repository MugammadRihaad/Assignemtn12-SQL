package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBranch;
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
public class BellvilleBranchControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/branch";

    @Test
    public void a_create() {

        BellvilleBranch baker = FactoryBellvilleBranch.getBellvillBranch();
        baker.setBellBrId("newId");

        ResponseEntity<BellvilleBranch> postResponse = restTemplate.postForEntity(baseURL + "/new", baker, BellvilleBranch.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        //returns an object as a pojo thus getForObject
        BellvilleBranch lookingFor = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleBranch.class);

        assertNotNull(lookingFor);

    }

    @Test
    public void c_update() {

        BellvilleBranch branch = restTemplate.getForObject(baseURL + "/find/" + "new", BellvilleBranch.class);
        branch.setBellBrId("newId-23");

        restTemplate.put(baseURL + "/update/" + "fas", branch);

        BellvilleBranch branchUpdated = restTemplate.getForObject(baseURL + "/update/" + "fas", BellvilleBranch.class);

        assertNotNull(branchUpdated);

    }

    @Test
    public void e_delete() {

        BellvilleBranch branch = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleBranch.class);
        assertNotNull(branch);

        restTemplate.delete(baseURL + "/delete/" + "fas");

        try {
            branch = restTemplate.getForObject(baseURL + "/find/" + "fas", BellvilleBranch.class);
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