package com.springboot.tutorial.demo01.entity;

import javax.persistence.*;

/**
 * @author xinj.xue
 * @description：城市实体类
 * @date 2017-08-26 0:58
 **/
@Entity
@Table(name = "city")
public class City extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name",length = 16)
    private String name;
    @ManyToOne
    private Province province;

    public City() {
    }

    public City(String name, Province province) {
        this.name = name;
        this.province = province;
    }

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}
