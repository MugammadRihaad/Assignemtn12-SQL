package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBellvilleAccountantTest {

    @Test
    public void getBellvilleAccountant() {


        BellvilleAccountant ba=FactoryBellvilleAccountant.getBellvilleAccountant();;

        Assert.assertNotNull(ba);
    }
}