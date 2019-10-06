package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.factory.Bellville.FactoryBellvilleBranch;
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
public class MPBranchRepositoryImplTest {

    @Autowired
    private MPBranchRepository branchRepository;


    @Test
    public void create() {
        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());
    }

    @Test
    public void read() {
        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());

        MPBranch branchInSet =branchRepository.read(branch.getMpBrId());

        assertEquals(branch,branchInSet);
    }

    @Test
    public void delete() {

        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchRepository.create(branch);


        assertNotNull(branchRepository.getAll());

        branchRepository.delete(branch.getMpBrId());


        MPBranch updatedVersion = branchRepository.read(branch.getMpBrId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPBranch branch = FactoryMPBranch.getMPBranch();
        branchRepository.create(branch);


        MPBranch branchUpdate = FactoryMPBranch.getMPBranch();
        branchUpdate.setMpBrId(branch.getMpBrId());
        branchRepository.update(branchUpdate);


        MPBranch updatedVersion = branchRepository.read(branchUpdate.getMpBrId());

        assertEquals(branchUpdate, updatedVersion);
    }


}