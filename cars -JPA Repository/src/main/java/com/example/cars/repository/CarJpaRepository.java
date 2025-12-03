package com.example.cars.repository;

import com.example.cars.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.List;

@Repository
@Transactional
public class CarJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public CarJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //1.adaug masina
    public Car adaugaMasina(Car car) {
        return entityManager.merge(car);
    }

    //2. sterg dupa nr de inmatriculare
    public void deleteByNrInmatriculare(String nr) {
        Car persoana = findByNrInmatriculare(nr);
        entityManager.remove(persoana);
    }//3. gasesc dupa nr de inmatriculare

    public Car findByNrInmatriculare(String nr) {
        return entityManager.find(Car.class, nr);
    }

    //4. find all masini
    public List<Car> findAll() {
        TypedQuery<Car> query = entityManager.createQuery("from masini ", Car.class);
        return query.getResultList();
    }

    // 5. Nr mașinile după marca
    public long countByBrand(String brand) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(c) FROM masini c WHERE c.brand = :brand", Long.class);
        query.setParameter("brand", brand);
        return query.getSingleResult();
    }

    // 6. Nr masini cu km < de 100000 km
    public long countCarsWithLowMileage() {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(c) FROM masini c WHERE c.nrKm < 100000", Long.class);
        return query.getSingleResult();
    }

    // 7. Gaseste masini mai noi de X ani
    public List<Car> findCarsNewerThanYears(int years) {
        int currentYear = Year.now().getValue();
        TypedQuery<Car> query = entityManager.createQuery(
                "SELECT c FROM masini c WHERE c.anFabricatie > :year", Car.class);
        query.setParameter("year", currentYear - years);
        return query.getResultList();
    }


}
