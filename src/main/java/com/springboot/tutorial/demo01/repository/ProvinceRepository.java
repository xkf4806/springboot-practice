package com.springboot.tutorial.demo01.repository;

import com.springboot.tutorial.demo01.entity.City;
import com.springboot.tutorial.demo01.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xinj.xue
 * @description：省份dao
 * @date 2017-08-26 1:36
 **/
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    @Query("SELECT c FROM City c where c.province.id = :provinceId")
    List<City> findByProvince(@Param("provinceId") Integer provinceId);
}
