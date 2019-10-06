package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.service.BellvilleService.BellvilleBranchService;
import ac.za.cput.service.BellvilleService.Impl.BellvilleBranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/bellbranch")
public class BellvilleBranchController {
    @Autowired
    @Qualifier("BellvilleBranchServiceImpl")
    private BellvilleBranchServiceImpl service;

    @PostMapping("/new")
    public BellvilleBranch create(@RequestBody BellvilleBranch branch){

        return service.create(branch);
    }

    @GetMapping(path = "/find/{id}")
    public BellvilleBranch findById(@PathVariable String id){

        BellvilleBranch branch = service.read(id);
        return branch;
    }

    @PutMapping("/update")
    public void update(@RequestBody BellvilleBranch baker){

        service.update(baker);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<BellvilleBranch> getAll(){
        return service.getAll();
    }

}
