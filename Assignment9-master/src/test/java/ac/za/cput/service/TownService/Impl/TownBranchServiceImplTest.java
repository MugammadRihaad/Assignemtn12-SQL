package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.factory.Town.FactoryTownBranch;
import ac.za.cput.repository.TownRepo.TownBranchRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TownBranchServiceImplTest {



    @Autowired
    private TownBranchServiceImpl branchService;


    @Test
    public void create() {
        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchService.create(branch);

        assertNotNull(branchService.getAll());
    }

    @Test
    public void read() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchService.create(branch);

        assertNotNull(branchService.getAll());

        TownBranch branchInSet =branchService.read(branch.getTnBrId());

        assertEquals(branch,branchInSet);
    }

    @Test
    public void delete() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchService.create(branch);


        assertNotNull(branchService.getAll());

        branchService.delete(branch.getTnBrId());


        TownBranch updatedVersion = branchService.read(branch.getTnBrId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchService.create(branch);


        TownBranch branchUpdate = FactoryTownBranch.getTownBranch();
        branchUpdate.setTnBrId(branch.getTnBrId());
        branchService.update(branchUpdate);


        TownBranch updatedVersion = branchService.read(branchUpdate.getTnBrId());

        assertEquals(branchUpdate, updatedVersion);
    }
}