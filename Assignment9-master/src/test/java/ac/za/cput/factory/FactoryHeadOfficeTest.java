package ac.za.cput.factory;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.factory.HeadOffice.FactoryHeadOffice;
import org.junit.Assert;
import org.junit.Test;

public class FactoryHeadOfficeTest {

    @Test
    public void getHeadOffice() {


        HeadOffice hd= FactoryHeadOffice.getHeadOffice();

        Assert.assertNotNull(hd);
    }
}