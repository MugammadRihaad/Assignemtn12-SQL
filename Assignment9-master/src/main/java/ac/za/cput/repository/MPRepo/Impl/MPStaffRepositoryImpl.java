package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.repository.MPRepo.MPStaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("MPStaffInMemory")
public class MPStaffRepositoryImpl implements MPStaffRepository {
    private static MPStaffRepositoryImpl repository = null;
    private Set<MPStaff> mpStaff;

    private MPStaffRepositoryImpl(){
        this.mpStaff = new HashSet<>();
    }

    public static MPStaffRepositoryImpl getRepository(){
        if (repository == null) repository = new MPStaffRepositoryImpl();
        return repository;
    }

    @Override
    public MPStaff create(MPStaff staff){
        this.mpStaff.add(staff);
        return staff;
    }
    @Override
    public MPStaff read(String staffId){
        return mpStaff.stream().filter(staff -> staff.getMpStaffId().equals(staffId)).findAny().orElse(null);
    }
    @Override
    public void delete(String staffId) {
        MPStaff toDelete = read(staffId);
        mpStaff.remove(toDelete);
    }
    @Override
    public MPStaff update(MPStaff staff){
        MPStaff toDelete = read(staff.getMpStaffId());
        if(toDelete != null) {
            mpStaff.remove(toDelete);
            mpStaff.add(staff);
            return staff;
        }
        return null;
    }

    @Override
    public Set<MPStaff> getAll(){
        return this.mpStaff;
    }
}
