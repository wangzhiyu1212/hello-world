package com.example.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.helloworld.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests {

//	@Autowired
//    private KieSession session;
	
	@Test
    public void customerTest() {
        Customer customer = new Customer();
        customer.setName("李刚");
        customer.setSex("M");
        Customer customer2 = new Customer();
        customer2.setName("天天");
        customer2.setSex("F");
//        session.insert(customer);//插入
//        session.insert(customer2);//插入
//        session.fireAllRules();//执行规则
    }
	
	@Test
	public void contextLoads() {
	}

}
