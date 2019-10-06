package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.repository.TownRepo.TownBakerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("TownBakerInMemory")
public class TownBakerRepositoryImpl implements TownBakerRepository {
    private static TownBakerRepositoryImpl repository = null;
    private Set<TownBaker> tnBaker;

    private TownBakerRepositoryImpl(){
        this.tnBaker = new HashSet<>();
    }

    public static TownBakerRepositoryImpl getRepository(){
        if (repository == null) repository = new TownBakerRepositoryImpl
    ();
        return repository;
    }

    @Override
    public TownBaker create(TownBaker baker){
        this.tnBaker.add(baker);
        return baker;
    }
    @Override
    public TownBaker read(String bakerId){
        return tnBaker.stream().filter(baker -> baker.getTnBakerId().equals(bakerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String bakerId) {
        TownBaker toDelete = read(bakerId);
        tnBaker.remove(toDelete);
    }
    @Override
    public TownBaker update(TownBaker baker){
        TownBaker toDelete = read(baker.getTnBakerId());
        if(toDelete != null) {
            tnBaker.remove(toDelete);
            tnBaker.add(baker);
            return baker;
        }
        return null;
    }

    @Override
    public Set<TownBaker> getAll(){
        return this.tnBaker;
    }
}
