package dev.mayur.productcatalogue.services;

import dev.mayur.productcatalogue.dtos.GenericProductDto;
import dev.mayur.productcatalogue.thirdpartyclients.FakeStoreProductDto;
import dev.mayur.productcatalogue.thirdpartyclients.FakeStoreProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
  /*  private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";
    private String specificProductRReqyestUrl = "https://fakestoreapi.com/products/{id}";
    private String updateProductRequestUrl = "https://fakestoreapi.com/products/"; */

   //@Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    @Autowired
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }
//-----------------------------------------------------------------------------------
    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }
//-----------------------------------------------------------------------------------
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("Inside PS-product Service");
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));

    }
//-----------------------------------------------------------------------------------
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }
//------------------------------------------------------------------------------------
    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }
//---------------------------------------------------------------------------------------
    @Override
    public GenericProductDto deleteProductById(long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }
//---------------------------------------------------------------------------------------

      public GenericProductDto updateProductById(GenericProductDto product, long id)  {
          return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProductById(product, id));
      }

//---------------------------------------------------------------------------------------
}
