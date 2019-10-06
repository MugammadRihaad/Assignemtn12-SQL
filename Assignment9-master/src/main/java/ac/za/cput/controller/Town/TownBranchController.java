package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.service.TownService.Impl.TownBranchServiceImpl;
import ac.za.cput.service.TownService.TownBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/townbranch")
public class TownBranchController {
    @Autowired
    @Qualifier("TownBranchServiceImpl")
    private TownBranchServiceImpl service;

    @PostMapping("/new")
    public TownBranch create(@RequestBody TownBranch accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public TownBranch findById(@PathVariable String id){

        TownBranch accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody TownBranch accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<TownBranch> getAll(){
        return service.getAll();
    }

}
