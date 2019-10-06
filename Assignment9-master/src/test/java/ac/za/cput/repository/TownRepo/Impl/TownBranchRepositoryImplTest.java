package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.factory.Bellville.FactoryBellvilleBranch;
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
public class TownBranchRepositoryImplTest {

    @Autowired
    private TownBranchRepository branchRepository;


    @Test
    public void create() {
        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());
    }

    @Test
    public void read() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());

        TownBranch branchInSet =branchRepository.read(branch.getTnBrId());

        assertEquals(branch,branchInSet);
    }

    @Test
    public void delete() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchRepository.create(branch);


        assertNotNull(branchRepository.getAll());

        branchRepository.delete(branch.getTnBrId());


        TownBranch updatedVersion = branchRepository.read(branch.getTnBrId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownBranch branch = FactoryTownBranch.getTownBranch();
        branchRepository.create(branch);


        TownBranch branchUpdate = FactoryTownBranch.getTownBranch();
        branchUpdate.setTnBrId(branch.getTnBrId());
        branchRepository.update(branchUpdate);


        TownBranch updatedVersion = branchRepository.read(branchUpdate.getTnBrId());

        assertEquals(branchUpdate, updatedVersion);
    }


}