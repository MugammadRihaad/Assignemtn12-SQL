package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.repository.BellvilleRepo.BellvilleBakerRepository;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleBakerRepositoryImpl;
import ac.za.cput.service.BellvilleService.BellvilleBakerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BellvilleBakerServiceImpl")
public class BellvilleBakerServiceImpl implements BellvilleBakerService {
    private  BellvilleBakerServiceImpl service = null;
    private BellvilleBakerRepository repository;

    private BellvilleBakerServiceImpl(){
        this.repository = BellvilleBakerRepositoryImpl.getRepository();
    }
    public BellvilleBakerServiceImpl getService(){
        if (service == null){
            service = new BellvilleBakerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<bellvilleBaker> getAll() {
        return this.repository.getAll();
    }

    @Override
    public bellvilleBaker create(bellvilleBaker baker) {
        return this.repository.create(baker);
    }

    @Override
    public bellvilleBaker read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public bellvilleBaker update(bellvilleBaker baker) {
        return this.repository.update(baker);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
