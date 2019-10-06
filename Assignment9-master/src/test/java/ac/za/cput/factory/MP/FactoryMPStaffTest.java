package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPStaff;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMPStaffTest {

    @Test
    public void getMPStaff() {


        MPStaff hd = FactoryMPStaff.getMPStaff();

        Assert.assertNotNull(hd);
    }
}