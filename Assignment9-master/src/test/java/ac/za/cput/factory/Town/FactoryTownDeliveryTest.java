package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownDelivery;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTownDeliveryTest {

    @Test
    public void getTownDelivery() {


        TownDelivery hd= FactoryTownDelivery.getTownDelivery();

        Assert.assertNotNull(hd);
    }
}