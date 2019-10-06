package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.factory.MP.FactoryMPStaff;
import ac.za.cput.repository.MPRepo.MPStaffRepository;
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
public class MPStaffServiceImplTest {



    @Autowired
    private MPStaffServiceImpl staffService;

    @Test
    public void create() {
        MPStaff staff = FactoryMPStaff.getMPStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());
    }

    @Test
    public void read() {

        MPStaff staff = FactoryMPStaff.getMPStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());

        MPStaff staffInSet =staffService.read(staff.getMpStaffId());

        assertEquals(staff,staffInSet);
    }

    @Test
    public void delete() {
        MPStaff staff = FactoryMPStaff.getMPStaff();
        staffService.create(staff);


        assertNotNull(staffService.getAll());

        staffService.delete(staff.getMpStaffId());


        MPStaff updatedVersion = staffService.read(staff.getMpStaffId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPStaff staff = FactoryMPStaff.getMPStaff();
        staffService.create(staff);


        MPStaff staffUpdate = FactoryMPStaff.getMPStaff();
        staffUpdate.setMpAccountId(staff.getMpAccountId());
        staffService.update(staffUpdate);


        MPStaff updatedVersion = staffService.read(staffUpdate.getMpStaffId());


    }
}