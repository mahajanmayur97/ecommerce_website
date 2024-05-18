package dev.mayur.productcatalogue;

import dev.mayur.productcatalogue.inheritancedemo.singletable.MentorRepository;
import dev.mayur.productcatalogue.inheritancedemo.singletable.UserRepository;
import dev.mayur.productcatalogue.models.Product;
import dev.mayur.productcatalogue.repositories.CategoryRepository;
import dev.mayur.productcatalogue.repositories.PriceRepository;
import dev.mayur.productcatalogue.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductcatalogueApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
	private UserRepository userRepository;
	private final PriceRepository priceRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public ProductcatalogueApplication(MentorRepository mentorRepository, UserRepository userRepository, CategoryRepository categoryRepository,  PriceRepository priceRepository, ProductRepository productRepository){
		this.mentorRepository = mentorRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//---------------------------------
	/*	Mentor mentor = new Mentor();
        mentor.setName("Naman1");
        mentor.setEmail("Naman@scaler.com1");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

		User user = new User();
        user.setName("Sarath1");
        user.setEmail("sarathcool@yopmail.com1");
        userRepository.save(user);

		List<User> users = userRepository.findAll();
        for (User user1: users) {
			System.out.println(user1);
		} */
//-------------------
//		Category category = new Category();
//		category.setName("Samsung Devices");
//	//	Category savedCategory = categoryRepository.save(category);
////-----------------
//		Price price = new Price("Rupee", 85);
//	//	Price savedPrice = priceRepository.save(price);
////-----------------
//		Product product = new Product();
//        product.setTitle("Samsung S24 Ultra");
//        product.setDescription("The best samsung Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        Product savedProduct = productRepository.save(product);
//-------------------

	//	productRepository.deleteById(UUID.fromString("0x14C1671C3A014AC493F3F956D4B750BC"));
//		System.out.println(productRepository.countAllByPrice_Currency("Rupee"));
//
//		List<Product> products = productRepository.findAllByPrice_Currency("Rupee");
//		for (Product products1: products) {
//			System.out.println(products1.getTitle());
//		}

//		Category category1 = categoryRepository.findById(UUID.fromString("0x0CBFE3FA46C940AEBDB1A1A343456FDB")).get();
//		System.out.println("Category name is: " + category1.getName());

		List<Product> products = productRepository.findAllByTitle("Samsung S24 Ultra");
		for (Product product1 : products){
			System.out.println(product1.getDescription());
		}
	}
}
