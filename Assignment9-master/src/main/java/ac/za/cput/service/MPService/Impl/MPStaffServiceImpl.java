package ac.za.cput.service.MPService.Impl;


import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.repository.MPRepo.Impl.MPStaffRepositoryImpl;
import ac.za.cput.repository.MPRepo.MPStaffRepository;
import ac.za.cput.service.MPService.MPStaffService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("MPStaffServiceImpl")
public class MPStaffServiceImpl implements MPStaffService {
    private  MPStaffServiceImpl service = null;
    private MPStaffRepository repository;

    private MPStaffServiceImpl(){
        this.repository = MPStaffRepositoryImpl.getRepository();
    }
    public MPStaffServiceImpl getService(){
        if (service == null){
            service = new MPStaffServiceImpl();
        }
        return service;
    }



    @Override
    public Set<MPStaff> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MPStaff create(MPStaff staff) {
        return this.repository.create(staff);
    }

    @Override
    public MPStaff read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public MPStaff update(MPStaff staff) {
        return this.repository.update(staff);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
