package com.xuli;

import com.xuli.domain.Gril;
import com.xuli.service.GirlService;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    @Transactional
    public void findOneTest(){
        Gril gril = girlService.findOneGirl(15);
        Assert.assertEquals(new Integer(5), gril.getAge());
    }
}
