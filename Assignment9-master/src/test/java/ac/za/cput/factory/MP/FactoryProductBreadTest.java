package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.ProductBread;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryProductBreadTest {

    @Test
    public void getProductBread() {

        String category="Burdger Rools";
        int amount=100;

        ProductBread hd=FactoryProductBread.getProductBread(category,amount);

        Assert.assertNotNull(hd);
    }
}