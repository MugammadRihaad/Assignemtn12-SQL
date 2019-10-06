package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.repository.TownRepo.Impl.TownStaffRepositoryImpl;
import ac.za.cput.repository.TownRepo.TownStaffRepository;
import ac.za.cput.service.TownService.TownStaffService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("TownStaffServiceImpl")
public class TownStaffServiceImpl implements TownStaffService {
    private  TownStaffServiceImpl service = null;
    private TownStaffRepository repository;

    private TownStaffServiceImpl(){
        this.repository = TownStaffRepositoryImpl.getRepository();
    }
    public TownStaffServiceImpl getService(){
        if (service == null){
            service = new TownStaffServiceImpl();
        }
        return service;
    }



    @Override
    public Set<TownStaff> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TownStaff create(TownStaff staff) {
        return this.repository.create(staff);
    }

    @Override
    public TownStaff read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public TownStaff update(TownStaff staff) {
        return this.repository.update(staff);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}

