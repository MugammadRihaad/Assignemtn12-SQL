package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBranch;
import ac.za.cput.repository.BellvilleRepo.BellvilleBakerRepository;
import ac.za.cput.repository.BellvilleRepo.BellvilleBranchRepository;
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
public class BellvilleBranchRepositoryImplTest {
    @Autowired
    private BellvilleBranchRepository branchRepository;

    @Test
    public void create() {
        BellvilleBranch branch = FactoryBellvilleBranch.getBellvillBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());
    }

    @Test
    public void read() {


        BellvilleBranch branch = FactoryBellvilleBranch.getBellvillBranch();
        branchRepository.create(branch);

        assertNotNull(branchRepository.getAll());

        BellvilleBranch branchInSet =branchRepository.read(branch.getBellBrId());

        assertEquals(branch,branchInSet);
    }

    @Test
    public void delete() {


        BellvilleBranch branch = FactoryBellvilleBranch.getBellvillBranch();
        branchRepository.create(branch);


        assertNotNull(branchRepository.getAll());

        branchRepository.delete(branch.getBellBrId());


        BellvilleBranch updatedVersion = branchRepository.read(branch.getBellBrId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {


        BellvilleBranch branch = FactoryBellvilleBranch.getBellvillBranch();
        branchRepository.create(branch);


        BellvilleBranch branchUpdate = FactoryBellvilleBranch.getBellvillBranch();
        branchUpdate.setBellBrId(branch.getBellBrId());
        branchRepository.update(branchUpdate);


        BellvilleBranch updatedVersion = branchRepository.read(branchUpdate.getBellBrId());

        assertEquals(branchUpdate, updatedVersion);
    }


}