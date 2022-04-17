package com.example.demo;

import com.example.demo.Repository.ProductRepo;
import com.example.demo.bean.ProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ProductRepo productRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		productRepository.save(new ProductBean("Thar",9,1300000));
		productRepository.save(new ProductBean("Fortuner",20,4100000));
		productRepository.save(new ProductBean("Innova",40,3100000));
		productRepository.save(new ProductBean("Range Rover",6,510000));

		System.out.println("\n findall()");
		productRepository.findAll().forEach(p-> System.out.println(p));

		System.out.println("\nfindbyid(1L)");
		productRepository.findById(1).ifPresent(p-> System.out.println(p));

		System.out.println("\n findbyname('Thar')");
		productRepository.findByName("Thar").forEach(p-> System.out.println(p));
	}

}