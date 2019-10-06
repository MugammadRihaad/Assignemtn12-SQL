package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.repository.TownRepo.Impl.TownBakerRepositoryImpl;
import ac.za.cput.repository.TownRepo.TownBakerRepository;
import ac.za.cput.service.TownService.TownBakerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("TownBakerServiceImpl")
public class TownBakerServiceImpl implements TownBakerService {
    private  TownBakerServiceImpl service = null;
    private TownBakerRepository repository;

    private TownBakerServiceImpl(){
        this.repository = TownBakerRepositoryImpl.getRepository();
    }
    public TownBakerServiceImpl getService(){
        if (service == null){
            service = new TownBakerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<TownBaker> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TownBaker create(TownBaker baker) {
        return this.repository.create(baker);
    }

    @Override
    public TownBaker read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public TownBaker update(TownBaker baker) {
        return this.repository.update(baker);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
