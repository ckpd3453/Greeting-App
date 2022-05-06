package com.bridgelabz.greetingMessage.repository;

import com.bridgelabz.greetingMessage.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository <Greeting, Long>{

}
