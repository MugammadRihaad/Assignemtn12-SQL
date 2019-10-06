package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
import ac.za.cput.repository.BellvilleRepo.BellvilleStaffRepository;
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
public class BellvilleStaffServiceImplTest {
    @Autowired
    private BellvilleStaffServiceImpl staffService;



    @Test
    public void create() {
        BellvilleStaff staff = FactoryBellvilleStaff.getBellvilleStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());
    }

    @Test
    public void read() {

        BellvilleStaff staff = FactoryBellvilleStaff.getBellvilleStaff();
        staffService.create(staff);

        assertNotNull(staffService.getAll());

        BellvilleStaff staffInSet =staffService.read(staff.getBellStaffId());

        assertEquals(staff,staffInSet);
    }

    @Test
    public void delete() {

        BellvilleStaff staff = FactoryBellvilleStaff.getBellvilleStaff();
        staffService.create(staff);


        assertNotNull(staffService.getAll());

        staffService.delete(staff.getBellStaffId());


        BellvilleStaff updatedVersion = staffService.read(staff.getBellStaffId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        BellvilleStaff staff = FactoryBellvilleStaff.getBellvilleStaff();
        staffService.create(staff);


        BellvilleStaff staffUpdate = FactoryBellvilleStaff.getBellvilleStaff();
        staffUpdate.setBellStaffId(staff.getBellStaffId());
        staffService.update(staffUpdate);


        BellvilleStaff updatedVersion = staffService.read(staffUpdate.getBellStaffId());

        assertEquals(staffUpdate, updatedVersion);
    }


}