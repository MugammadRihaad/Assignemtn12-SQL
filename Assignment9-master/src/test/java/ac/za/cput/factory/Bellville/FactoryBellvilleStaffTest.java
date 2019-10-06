package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBellvilleStaffTest {

    @Test
    public void getBellvilleStaff() {

        BellvilleStaff hd=FactoryBellvilleStaff.getBellvilleStaff();

        Assert.assertNotNull(hd);
    }
}