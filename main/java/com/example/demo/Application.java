package com.example.demo;


        import com.example.demo.Repository.SelfRepo;
        import com.example.demo.bean.SelfBeans;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SelfRepo selfRepo;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        selfRepo.save(new SelfBeans("Akshata"));
        selfRepo.save(new SelfBeans("Rokey"));
        selfRepo.save(new SelfBeans("Sanket"));
        selfRepo.save(new SelfBeans("Rashmi"));

        System.out.println("\n findall()");
        selfRepo.findAll().forEach(u-> System.out.println(u));

        System.out.println("\n findbyid(1L)");
       selfRepo.findById(1).ifPresent(u-> System.out.println(u));

        System.out.println("\n findbyname('Sanket')");
        selfRepo.findByName("Sanket").forEach(u-> System.out.println(u));
    }

}