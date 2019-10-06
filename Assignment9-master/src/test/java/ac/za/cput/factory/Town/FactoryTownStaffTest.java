package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownStaff;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTownStaffTest {

    @Test
    public void getTownStaff() {


        TownStaff hd=FactoryTownStaff.getTownStaff();

        Assert.assertNotNull(hd);
    }
}