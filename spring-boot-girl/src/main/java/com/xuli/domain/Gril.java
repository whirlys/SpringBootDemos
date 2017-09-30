package com.xuli.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/17.
 */
    @Entity
    public class Gril {

        @Id
        @GeneratedValue
        private Integer id;

        private String cupSize;


        @Min(value = 18, message = "您输入的年龄小于18！")
        @NotNull(message = "年龄必填。")
        private Integer age;

        public Gril() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCupSize() {
            return cupSize;
        }

        public void setCupSize(String cupSize) {
            this.cupSize = cupSize;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Gril{" +
                    "id=" + id +
                    ", cupSize='" + cupSize + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
