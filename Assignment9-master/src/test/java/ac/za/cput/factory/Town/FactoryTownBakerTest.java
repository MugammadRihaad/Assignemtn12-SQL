package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownBaker;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTownBakerTest {

    @Test
    public void getTownBaker() {


            String tnBakerName="Michelle";
            double tnBakerSalary=10000;

            TownBaker hd=FactoryTownBaker.getTownBaker(tnBakerName,tnBakerSalary);

            Assert.assertNotNull(hd);
        }
    }
