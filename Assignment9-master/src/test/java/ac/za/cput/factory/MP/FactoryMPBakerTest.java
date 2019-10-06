package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPBaker;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMPBakerTest {

    @Test
    public void getMPBaker() {


            String mpBakerName="bbn780";
            double mpBakerSalary=10000;

            MPBaker hd=FactoryMPBaker.getMPBaker(mpBakerName,mpBakerSalary);

            Assert.assertNotNull(hd);
        }
    }
