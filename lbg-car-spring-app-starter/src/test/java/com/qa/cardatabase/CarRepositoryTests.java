package com.qa.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.cardatabase.data.entity.Car;
import com.qa.cardatabase.data.repository.CarRepository;
import com.qa.cardatabase.data.entity.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveCar(){
        Owner me = new Owner();
        me.setFirstname("Victoria");
        entityManager.persistAndFlush(me);
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, me);
        entityManager.persistAndFlush(car);

        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars() {
        Owner me = new Owner();
        me.setFirstname("Victoria");
        entityManager.persistAndFlush(me);
        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White","ABC-1234", 2017, 86000, me));
        entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500, me));

        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();
    }
}
