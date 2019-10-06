package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPAccountant;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMPAccountantTest {

    @Test
    public void getMPAccountant() {

        MPAccountant ma=FactoryMPAccountant.getMPAccountant();

        Assert.assertNotNull(ma);
    }
}