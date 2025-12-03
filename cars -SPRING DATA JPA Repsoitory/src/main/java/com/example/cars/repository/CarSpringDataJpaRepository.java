package com.example.cars.repository;

import com.example.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Repository
public interface CarSpringDataJpaRepository extends JpaRepository<Car, String> {

    //a. Adaug masina- JpaRepository.save()
    //b. Sterge dupa nrInmatriculare -JpaReposirtory.deleteById()
    //c. Gaseste dupa nrinmatriculare -JpaReposirtory.findById()
    //d. Toate masinile - JpaReposirtory.findAll()

    //e. Nr masini de un anumit brand
    long countByBrand(String brand);

    //f. Nr masini cu km< 100.000
    long countByNrKmLessThan(Integer km);

    //g. Extragere masini mai noi de 5 ani.
    @Query("SELECT c FROM Car c WHERE c.anFabricatie >= (:currentYear - :years)")
    List<Car> findCarsNewerThanYears(@Param("currentYear") Integer currentYear,
                                     @Param("years") Integer years);
}
