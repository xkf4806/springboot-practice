package com.springboot.demo01.service.impl;

import com.springboot.demo01.common.PageInfo;
import com.springboot.demo01.entity.User;
import com.springboot.demo01.service.UserService;
import com.springboot.demo01.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(Parameterized.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private String json;
    private TestContextManager testContextManager ;

    public static String param = "{\n" +
            "\"pageInfo\":{\n" +
            "  \"pageNum\":1,\n" +
            "  \"pageSize\":3 \n" +
            "},\n" +
//            "\"name\":\"aa\",\n" +
            "\"age\":32}";

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

    public UserServiceImplTest(String json) {
        this.json = json;
    }

    @Test
    public void findUserByPage() throws Exception {
        Map<String, Object> param = JsonUtils.getInstance().toMapObject(json);
        PageInfo pageInfo = userService.findUserByPage(param);
        List<User> data = pageInfo.getData();
        for (User user : data) {
            System.out.println(user);
        }
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        List<String[]> items = new ArrayList<>();
        String[] datas = new String[] {param};
        items.add(datas);
        return items;
    }
}