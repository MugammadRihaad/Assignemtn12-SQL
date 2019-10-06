package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.repository.BellvilleRepo.BellvilleStaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("BellvilleStaffInMemory")
public class BellvilleStaffRepositoryImpl implements BellvilleStaffRepository {
    private static BellvilleStaffRepositoryImpl repository = null;
    private Set<BellvilleStaff> bellStaff;

    private BellvilleStaffRepositoryImpl(){
        this.bellStaff = new HashSet<>();
    }

    public static BellvilleStaffRepositoryImpl getRepository(){
        if (repository == null) repository = new BellvilleStaffRepositoryImpl();
        return repository;
    }

    @Override
    public BellvilleStaff create(BellvilleStaff staff){
        this.bellStaff.add(staff);
        return staff;
    }
    @Override
    public BellvilleStaff read(String staffId){
        return bellStaff.stream().filter(staff -> staff.getBellStaffId().equals(staffId)).findAny().orElse(null);
    }
    @Override
    public void delete(String staffId) {
        BellvilleStaff inDelete=read(staffId);
        bellStaff.remove(inDelete);
    }
    @Override
    public BellvilleStaff update(BellvilleStaff staff){
        BellvilleStaff inDelete = read(staff.getBellStaffId());

        if(inDelete != null){
            bellStaff.remove(inDelete);
            bellStaff.add(staff);
            return staff;
        }

        return null;
    }

    @Override
    public Set<BellvilleStaff> getAll(){
        return this.bellStaff;
    }
}
