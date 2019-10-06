package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBellvilleBakerTest {

    @Test
    public void getBellvilleBaker() {

        String bellBakerName="bbn780";
        double bellBakerSalary=10000;

        bellvilleBaker hd=FactoryBellvilleBaker.getBellvilleBaker(bellBakerName,bellBakerSalary);

        Assert.assertNotNull(hd);
    }
}