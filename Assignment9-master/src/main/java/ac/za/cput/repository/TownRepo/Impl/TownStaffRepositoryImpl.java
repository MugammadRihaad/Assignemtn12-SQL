package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.repository.TownRepo.TownStaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("TownStaffInMemory")
public class TownStaffRepositoryImpl implements TownStaffRepository {
    private static TownStaffRepositoryImpl repository = null;
    private Set<TownStaff> tnStaff;

    private TownStaffRepositoryImpl(){
        this.tnStaff = new HashSet<>();
    }

    public static TownStaffRepositoryImpl getRepository(){
        if (repository == null) repository = new TownStaffRepositoryImpl();
        return repository;
    }

    @Override
    public TownStaff create(TownStaff staff){
        this.tnStaff.add(staff);
        return staff;
    }
    @Override
    public TownStaff read(String staffId){
        return tnStaff.stream().filter(staff -> staff.getTnStaffId().equals(staffId)).findAny().orElse(null);
    }
    @Override
    public void delete(String staffId) {
        TownStaff toDelete = read(staffId);
        tnStaff.remove(toDelete);
    }
    @Override
    public TownStaff update(TownStaff staff){
        TownStaff toDelete = read(staff.getTnStaffId());
        if(toDelete != null) {
            tnStaff.remove(toDelete);
            tnStaff.add(staff);
            return staff;
        }
        return null;
    }

    @Override
    public Set<TownStaff> getAll(){
        return this.tnStaff;
    }
}
