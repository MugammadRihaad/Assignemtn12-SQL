package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.ProductCakes;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryProductCakesTest {

    @Test
    public void getProductCakes() {

        String category="Chocolate";
        int amount=200;

        ProductCakes hd=FactoryProductCakes.getProductCakes(category,amount);

        Assert.assertNotNull(hd);
    }
}