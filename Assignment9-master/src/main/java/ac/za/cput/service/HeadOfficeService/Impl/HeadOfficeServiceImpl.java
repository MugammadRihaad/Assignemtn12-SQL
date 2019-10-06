package ac.za.cput.service.HeadOfficeService.Impl;


import ac.za.cput.domain.HeadOffice;
import ac.za.cput.repository.HeadOffice.HeadOfficeRepository;
import ac.za.cput.repository.HeadOffice.Impl.HeadOfficeRepositoryImpl;
import ac.za.cput.service.HeadOfficeService.HeadOfficeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("HeadOfficeServiceImpl")
public class HeadOfficeServiceImpl implements HeadOfficeService {
    private  HeadOfficeServiceImpl service = null;
    private HeadOfficeRepository repository;

    private HeadOfficeServiceImpl(){
        this.repository = HeadOfficeRepositoryImpl.getRepository();
    }
    public HeadOfficeServiceImpl getService(){
        if (service == null){
            service = new HeadOfficeServiceImpl();
        }
        return service;
    }



    @Override
    public Set<HeadOffice> getAll() {
        return this.repository.getAll();
    }

    @Override
    public HeadOffice create(HeadOffice office) {
        return this.repository.create(office);
    }

    @Override
    public HeadOffice read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public HeadOffice update(HeadOffice office) {
        return this.repository.update(office);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
