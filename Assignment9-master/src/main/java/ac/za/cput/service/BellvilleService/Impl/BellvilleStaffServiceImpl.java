package ac.za.cput.service.BellvilleService.Impl;


import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.repository.BellvilleRepo.BellvilleStaffRepository;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleStaffRepositoryImpl;
import ac.za.cput.service.BellvilleService.BellvilleStaffService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BellvilleStaffServiceImpl")
public class BellvilleStaffServiceImpl implements BellvilleStaffService {
    private  BellvilleStaffServiceImpl service = null;
    private BellvilleStaffRepository repository;

    private BellvilleStaffServiceImpl(){
        this.repository = BellvilleStaffRepositoryImpl.getRepository();
    }
    public BellvilleStaffServiceImpl getService(){
        if (service == null){
            service = new BellvilleStaffServiceImpl();
        }
        return service;
    }



    @Override
    public Set<BellvilleStaff> getAll() {
        return this.repository.getAll();
    }

    @Override
    public BellvilleStaff create(BellvilleStaff staff) {
        return this.repository.create(staff);
    }

    @Override
    public BellvilleStaff read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public BellvilleStaff update(BellvilleStaff staff) {
        return this.repository.update(staff);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
