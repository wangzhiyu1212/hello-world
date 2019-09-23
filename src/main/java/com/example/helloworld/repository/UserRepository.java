package com.example.helloworld.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.helloworld.entity.User;

public interface UserRepository extends MongoRepository<User,String> {//第一个参数 哪个类,第二个参数id类型

}
