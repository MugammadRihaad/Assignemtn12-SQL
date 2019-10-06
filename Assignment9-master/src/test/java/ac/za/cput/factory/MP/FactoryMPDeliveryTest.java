package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPDelivery;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMPDeliveryTest {

    @Test
    public void getMPDelivery() {

        MPDelivery hd= FactoryMPDelivery.getMPDelivery();

        Assert.assertNotNull(hd);
    }
}