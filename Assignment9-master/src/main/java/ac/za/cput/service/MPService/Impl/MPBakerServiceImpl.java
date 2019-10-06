package ac.za.cput.service.MPService.Impl;


import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.repository.MPRepo.Impl.MPBakerRepositoryImpl;
import ac.za.cput.repository.MPRepo.MPBakerRepository;
import ac.za.cput.service.MPService.MPBakerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("MPBakerServiceImpl")
public class MPBakerServiceImpl implements MPBakerService {
    private  MPBakerServiceImpl service = null;
    private MPBakerRepository repository;

    private MPBakerServiceImpl(){
        this.repository = MPBakerRepositoryImpl.getRepository();
    }
    public MPBakerServiceImpl getService(){
        if (service == null){
            service = new MPBakerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<MPBaker> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MPBaker create(MPBaker baker) {
        return this.repository.create(baker);
    }

    @Override
    public MPBaker read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public MPBaker update(MPBaker baker) {
        return this.repository.update(baker);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}

