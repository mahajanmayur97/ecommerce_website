package dev.mayur.productcatalogue.services;

import dev.mayur.productcatalogue.dtos.GenericProductDto;
import dev.mayur.productcatalogue.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URISyntaxException;
import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);
    GenericProductDto createProduct(GenericProductDto product);
    public List<GenericProductDto> getAllProducts();
    public GenericProductDto deleteProductById(long id);
    GenericProductDto updateProductById(GenericProductDto product, long id);
}
