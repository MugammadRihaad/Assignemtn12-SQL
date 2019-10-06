package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.factory.MP.FactoryMPBranch;
import ac.za.cput.repository.MPRepo.MPBranchRepository;
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
public class MPBranchServiceImplTest {


    @Autowired
    private MPBranchServiceImpl branchService;


    @Test
    public void create() {
        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchService.create(branch);

        assertNotNull(branchService.getAll());
    }

    @Test
    public void read() {
        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchService.create(branch);

        assertNotNull(branchService.getAll());

        MPBranch branchInSet =branchService.read(branch.getMpBrId());

        assertEquals(branch,branchInSet);
    }

    @Test
    public void delete() {

        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchService.create(branch);


        assertNotNull(branchService.getAll());

        branchService.delete(branch.getMpBrId());


        MPBranch updatedVersion = branchService.read(branch.getMpBrId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchService.create(branch);


        MPBranch branchUpdate = FactoryMPBranch.getMPBranch();
        branchUpdate.setMpBrId(branch.getMpBrId());
        branchService.update(branchUpdate);


        MPBranch updatedVersion = branchService.read(branchUpdate.getMpBrId());

        assertEquals(branchUpdate, updatedVersion);
    }
}