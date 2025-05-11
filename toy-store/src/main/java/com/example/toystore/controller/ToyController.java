import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToyController {

    private final ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public List<Toy> getAllToys() {
        return toyService.getAllToys();
    }

    @PostMapping
    public void addToy(@RequestBody Toy toy) {
        toyService.addToy(toy);
    }
}