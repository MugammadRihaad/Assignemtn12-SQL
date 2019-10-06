package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.factory.Town.FactoryTownStaff;
import ac.za.cput.repository.TownRepo.TownStaffRepository;
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
public class TownStaffServiceImplTest {


    @Autowired
    private TownStaffServiceImpl staffService;



    @Test
    public void create() {
        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());
    }

    @Test
    public void read() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());

        TownStaff staffInSet =staffService.read(staff.getTnStaffId());

        assertEquals(staff,staffInSet);
    }

    @Test
    public void delete() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffService.create(staff);


        assertNotNull(staffService.getAll());

        staffService.delete(staff.getTnStaffId());


        TownStaff updatedVersion = staffService.read(staff.getTnStaffId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffService.create(staff);


        TownStaff staffUpdate = FactoryTownStaff.getTownStaff();
        staffUpdate.setTnStaffId(staff.getTnStaffId());
        staffService.update(staffUpdate);


        TownStaff updatedVersion = staffService.read(staffUpdate.getTnStaffId());

        assertEquals(staffUpdate, updatedVersion);
    }
}