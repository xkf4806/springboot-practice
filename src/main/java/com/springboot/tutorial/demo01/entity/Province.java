package com.springboot.tutorial.demo01.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author xinj.xue
 * @description：省份
 * @date 2017-08-26 1:05
 **/
@Entity
@Table(name = "province")
public class Province extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 16)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "province", cascade = CascadeType.ALL)
    private List<City> cities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Province() {

    }

    public Province(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cities.size=" + cities.size() +
                '}';
    }
}
