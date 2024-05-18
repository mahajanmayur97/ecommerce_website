package dev.mayur.productcatalogue.scalerController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScalerController {
    @GetMapping("/hi")
    public String Method(){
        return "Hey Hi Its Scaler Student";
    }
}
