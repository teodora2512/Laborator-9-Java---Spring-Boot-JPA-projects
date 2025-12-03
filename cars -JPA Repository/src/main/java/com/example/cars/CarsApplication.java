package com.example.cars;

import com.example.cars.entity.Car;
import com.example.cars.repository.CarJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner {
    @Autowired
    CarJpaRepository repository;

    public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(String... args) throws Exception {


        System.out.println("-------JPA-------");
        System.out.println("\nContinutul initial al tabelei masini:");
        repository.findAll().forEach(System.out::println);

        System.out.println("\na. Adaugare masina in baza de date:");
        repository.adaugaMasina(new Car("B-123-ABC", "Toyota", 2020, "Red", 45000));
        repository.findAll().forEach(System.out::println);

        System.out.println("\nb. Stergere masina din baza de date: ");
        repository.deleteByNrInmatriculare("B-123-ABC");
       repository.findAll().forEach(System.out::println);

        System.out.println("\nc. Căutarea unei mașini după numărul de înmatriculare");
     //  Car masinaGasita= repository.findByNrInmatriculare("B-123-ABC");
      //if(masinaGasita!=null) System.out.println(masinaGasita);
        logger.info("\nMasina cu nr-ul B-123-ABC->{}",repository.findByNrInmatriculare("B-123-ABC"));

        System.out.println("\nd. Extragerea unei liste care conţine toate mașinile din baza de date");
        List<Car> lista= repository.findAll();
        lista.forEach(System.out::println);

        System.out.println("\ne. Determinarea numărului de mașini din BD care au o anumită marcă, introdusă de la\n" +
                "tastatură.");
        Scanner scanner=new Scanner(System.in);
        String marca;
        System.out.println("\nIntroduceti marca: ");
        marca=scanner.nextLine();
        System.out.println(repository.countByBrand(marca));


        System.out.println("\nf. Determinarea numărului de mașini din BD care au sub 100 000 km.");
        System.out.println(repository.countCarsWithLowMileage());

        System.out.println("\ng. Extragera unei liste care conţine maşinile mai noi de 5 ani.");
        var listaMasiniNoi=repository.findCarsNewerThanYears(5);
        listaMasiniNoi.forEach(System.out::println);

    }
}