package com.example.cars;

import com.example.cars.entity.Car;
import com.example.cars.repository.CarSpringDataJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Year;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(CarsApplication.class);

    @Autowired
    CarSpringDataJpaRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------SPRING DATA JPA-------");
        System.out.println("\nContinutul initial al tabelei masini:");
        repository.findAll().forEach(System.out::println);

        System.out.println("\na. Adaugare masina in baza de date:");
        repository.save(new Car("B-123-ABC", "Toyota", 2020, "Red", 45000));
        repository.findAll().forEach(System.out::println);

        System.out.println("\nb. Stergere masina din baza de date: ");
        repository.deleteById("B-123-ABC");
        repository.findAll().forEach(System.out::println);

        System.out.println("\nc. Căutarea unei mașini după numărul de înmatriculare");
        //  Car masinaGasita= repository.findByNrInmatriculare("B-123-ABC");
        //if(masinaGasita!=null) System.out.println(masinaGasita);
        logger.info("\nMasina cu nr-ul B-123-ABC->{}",repository.findById("B-123-ABC"));

       // System.out.println("\nd. Extragerea unei liste care conţine toate mașinile din baza de date");
        //List<Car> lista= repository.findAll();
       // lista.forEach(System.out::println);
        String carsList = repository.findAll().stream()
                .map(Car::toString)
                .collect(Collectors.joining(", "));
        logger.info("\nLista cu mașinile din BD: {}", carsList);


        System.out.println("\ne. Determinarea numărului de mașini din BD care au o anumită marcă, introdusă de la\n" +
                "tastatură.");
        Scanner scanner=new Scanner(System.in);
        String marca;
        System.out.println("\nIntroduceti marca: ");
        marca=scanner.nextLine();
        System.out.println(repository.countByBrand(marca));


        System.out.println("\nf. Determinarea numărului de mașini din BD care au sub 100 000 km.");
        System.out.println(repository.countByNrKmLessThan(100000));

        System.out.println("\ng. Extragera unei liste care conţine maşinile mai noi de 5 ani.");
        var listaMasiniNoi=repository.findCarsNewerThanYears(Year.now().getValue(),5);
        listaMasiniNoi.forEach(System.out::println);

    }
}
