package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
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
public class TownStaffRepositoryImplTest {

    @Autowired
    private TownStaffRepository staffRepository;



    @Test
    public void create() {
        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffRepository.create(staff);

        assertNotNull(staffRepository.getAll());
    }

    @Test
    public void read() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffRepository.create(staff);

        assertNotNull(staffRepository.getAll());

        TownStaff staffInSet =staffRepository.read(staff.getTnStaffId());

        assertEquals(staff,staffInSet);
    }

    @Test
    public void delete() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffRepository.create(staff);


        assertNotNull(staffRepository.getAll());

        staffRepository.delete(staff.getTnStaffId());


        TownStaff updatedVersion = staffRepository.read(staff.getTnStaffId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownStaff staff = FactoryTownStaff.getTownStaff();
        staffRepository.create(staff);


        TownStaff staffUpdate = FactoryTownStaff.getTownStaff();
        staffUpdate.setTnStaffId(staff.getTnStaffId());
        staffRepository.update(staffUpdate);


        TownStaff updatedVersion = staffRepository.read(staffUpdate.getTnStaffId());

        assertEquals(staffUpdate, updatedVersion);
    }


}