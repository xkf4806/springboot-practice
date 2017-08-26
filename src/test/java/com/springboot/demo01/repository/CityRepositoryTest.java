package com.springboot.demo01.repository;

import com.springboot.demo01.entity.City;
import com.springboot.demo01.entity.Province;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
@SpringBootTest
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    private TestContextManager testContextManager ;
    private Integer cId;

    //每次运行都会执行  与 @BeforeClass的区别
    @Before
    public void setUp(){
        //自动注解与@RunWith(SpringJUnit4ClassRunner.class) 效果一样
        testContextManager = new TestContextManager(getClass()) ;
        try {
            testContextManager.prepareTestInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CityRepositoryTest(Integer cId) {
        this.cId = cId;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[] cids = new Object[]{3};
        List<Object[]> ret = new ArrayList<>();
        ret.add(cids);
        return ret;
    }

    @Test
    public void findByCity() throws Exception {
        Province province = cityRepository.findByCity(cId);
        System.out.println(province);
    }

    @Test
    public void findByName() throws Exception {
        City city = cityRepository.findByName("太原市");
        System.out.println(city);
    }


}