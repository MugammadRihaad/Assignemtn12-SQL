package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPBranch;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMPBranchTest {

    @Test
    public void getMPBranch() {


        MPBranch hd=FactoryMPBranch.getMPBranch();

        Assert.assertNotNull(hd);

    }
    }
