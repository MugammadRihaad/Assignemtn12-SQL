package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownAccountant;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTownAccountantTest {

    @Test
    public void getTownAccountant() {


        TownAccountant ta=FactoryTownAccountant.getTownAccountant();

        Assert.assertNotNull(ta);
    }
}