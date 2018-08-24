package com.springboot.tutorial.demo01.repository;

import com.springboot.tutorial.demo01.entity.City;
import com.springboot.tutorial.demo01.entity.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceRepositoryTest {
    @Autowired
    private ProvinceRepository repository;
    @Test
    public void findByProvince() throws Exception {
        List<City> cities = repository.findByProvince(2);
        System.out.println(cities);
    }

    @Test
    public void saveProvince() {
        Province province = new Province();
        province.setName("山东省");
        List<City> cities = new ArrayList<>();
        cities.add(new City("济南市",province));
        cities.add(new City("青岛市",province));
        cities.add(new City("淄博市",province));

        province.setCities(cities);
        repository.save(province);
    }

}