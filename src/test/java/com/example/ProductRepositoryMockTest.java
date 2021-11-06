package com.example;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	ProductRepository productRepository;
	
	@Test
    public void whenFindByCategory_thenReturnListProduct(){
		Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds= productRepository.findByCategory(product01.getCategory());

        Assertions.assertEquals(founds.size(), 3);

    }
}
