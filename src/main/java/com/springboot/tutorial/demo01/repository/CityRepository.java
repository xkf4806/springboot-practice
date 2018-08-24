package com.springboot.tutorial.demo01.repository;

import com.springboot.tutorial.demo01.entity.City;
import com.springboot.tutorial.demo01.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author xinj.xue
 * @description：城市dao
 * @date 2017-08-26 1:24
 **/
public interface CityRepository extends JpaRepository<City,Integer> {
    City findByName(String name);

    @Query("select p from Province p where p.id = (select c.province.id from City c where c.id = :cId)")
    Province findByCity(@Param("cId") Integer cId);
}
