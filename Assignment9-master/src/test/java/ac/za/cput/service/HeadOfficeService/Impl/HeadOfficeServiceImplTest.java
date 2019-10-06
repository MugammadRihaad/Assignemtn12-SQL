package ac.za.cput.service.HeadOfficeService.Impl;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.factory.HeadOffice.FactoryHeadOffice;
import ac.za.cput.repository.HeadOffice.HeadOfficeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadOfficeServiceImplTest {

    @Autowired
    private HeadOfficeServiceImpl officeService;



    @Test
    public void create() {
        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeService.create(office);

        assertNotNull(officeService.getAll());
    }

    @Test
    public void read() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeService.create(office);

        assertNotNull(officeService.getAll());

        HeadOffice officeInSet =officeService.read(office.getOfficeId());

        assertEquals(office,officeInSet);
    }

    @Test
    public void delete() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeService.create(office);


        assertNotNull(officeService.getAll());

        officeService.delete(office.getOfficeId());


        HeadOffice updatedVersion = officeService.read(office.getOfficeId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeService.create(office);


        HeadOffice officeUpdate = FactoryHeadOffice.getHeadOffice();
        officeUpdate.setBellvilleBrId(office.getBellvilleBrId());
        officeService.update(officeUpdate);


        HeadOffice updatedVersion = officeService.read(officeUpdate.getOfficeId());


    }
}