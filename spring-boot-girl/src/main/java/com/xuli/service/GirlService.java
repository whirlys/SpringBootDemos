package com.xuli.service;

import com.xuli.enums.ResultEnum;
import com.xuli.exception.GirlExpection;
import com.xuli.repository.GirlRepository;
import com.xuli.domain.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Gril girlA = new Gril();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Gril girlB = new Gril();
        girlB.setCupSize("Bbb");
        girlB.setAge(192);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Gril gril = girlRepository.findOne(id);
        Integer age = gril.getAge();
        if (age<10){
            // 返回"你还在上小学" code=100
            throw new GirlExpection(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            // 返回"你在上初中吧" code=101
            throw new GirlExpection(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Idc查询一条信息
     * @param id
     */
    public Gril findOneGirl(Integer id){
        System.out.print("9999");
        return girlRepository.getOne(id);
    }
}
