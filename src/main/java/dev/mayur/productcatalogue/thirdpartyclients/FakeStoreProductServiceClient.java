package dev.mayur.productcatalogue.thirdpartyclients;

import dev.mayur.productcatalogue.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    private String productRequestsBaseUrl = "https://fakestoreapi.com/products";
    private String specificProductRReqyestUrl = "https://fakestoreapi.com/products/{id}";
    private String updateProductRequestUrl = "https://fakestoreapi.com/products/";
//----------------------------------------------------------------------------------------------------------------
    public  FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
//----------------------------------------------------------------------------------------------------------------
    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response
                = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }
//----------------------------------------------------------------------------------------------------------------

    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                createProductRequestUrl, product , FakeStoreProductDto.class
        );
        return response.getBody();
    }
//------------------------------------------------------------------------------------------------------------------
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();
    }
//------------------------------------------------------------------------------------------------------------------
    public FakeStoreProductDto deleteProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductRReqyestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }
//----------------------------------------------------------------------------------------------------------------
    public FakeStoreProductDto updateProductById(GenericProductDto product, long id)  {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response
                = restTemplate.getForEntity(updateProductRequestUrl+id, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());

        URI uri = null;
        try {
            uri = new URI(updateProductRequestUrl + id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        restTemplate.put(uri,fakeStoreProductDto);
        return fakeStoreProductDto;
    }
//------------------------------------------------------------------------------------------------------------------

}



    
