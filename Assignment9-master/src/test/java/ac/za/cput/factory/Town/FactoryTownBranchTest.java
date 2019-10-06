package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownBranch;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTownBranchTest {

    @Test
    public void getTownBranch() {


        TownBranch hd=FactoryTownBranch.getTownBranch();

        Assert.assertNotNull(hd);
    }
    }
