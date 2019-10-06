package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.factory.StockDeliveries.FactoryDeliveries;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBellvilleDeliveryTest {

    @Test
    public void getBellvilleDelivery() {


        BellvilleDelivery hd= FactoryBellvilleDelivery.getBellvilleDelivery();

        Assert.assertNotNull(hd);
    }
}