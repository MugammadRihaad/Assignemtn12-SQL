package ac.za.cput.repository.HeadOffice.Impl;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.domain.HeadOffice;
import ac.za.cput.factory.Bellville.FactoryProductCakes;
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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadOfficeRepositoryImplTest {

    @Autowired
    private HeadOfficeRepository officeRepository;



    @Test
    public void create() {
        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeRepository.create(office);

        assertNotNull(officeRepository.getAll());
    }

    @Test
    public void read() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeRepository.create(office);

        assertNotNull(officeRepository.getAll());

        HeadOffice officeInSet =officeRepository.read(office.getOfficeId());

        assertEquals(office,officeInSet);
    }

    @Test
    public void delete() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeRepository.create(office);


        assertNotNull(officeRepository.getAll());

        officeRepository.delete(office.getOfficeId());


        HeadOffice updatedVersion = officeRepository.read(office.getOfficeId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        HeadOffice office = FactoryHeadOffice.getHeadOffice();
        officeRepository.create(office);


        HeadOffice officeUpdate = FactoryHeadOffice.getHeadOffice();
        officeUpdate.setBellvilleBrId(office.getBellvilleBrId());
        officeRepository.update(officeUpdate);


        HeadOffice updatedVersion = officeRepository.read(officeUpdate.getOfficeId());

        assertNull(updatedVersion);
    }


}