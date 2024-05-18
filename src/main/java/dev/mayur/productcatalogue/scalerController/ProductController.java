package dev.mayur.productcatalogue.scalerController;

import dev.mayur.productcatalogue.dtos.GenericProductDto;
import dev.mayur.productcatalogue.security.TokenValidator;
import dev.mayur.productcatalogue.services.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;
    private TokenValidator tokenValidator;
    public ProductController(ProductService productService, TokenValidator tokenValidator){
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }

//-------------------------------------------------------------------------
    @GetMapping("{id}")
    public GenericProductDto getProductById(@Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken  , @PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        System.out.println("Inside PS-getProductById");
        System.out.println(authToken);

        if(authToken != null){
            Optional<Boolean> valid = tokenValidator.validateToken(authToken);
            if(valid.get() == false) {
                throw new RuntimeException("User not valid");
            }
        }
        return productService.getProductById(id);
    }
//-------------------------------------------------------------------------

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }
//------------------------------------------------------------------------
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
//-------------------------------------------------------------------------
    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id){
        return productService.deleteProductById(id);
    }
//-------------------------------------------------------------------------
   @PutMapping("{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto product, @PathVariable("id") long id){
        return productService.updateProductById(product, id);


    }
}
