package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBellvilleBranchTest {

    @Test
    public void getBellvillBranch() {


        BellvilleBranch hd=FactoryBellvilleBranch.getBellvillBranch();

        Assert.assertNotNull(hd);
    }
}