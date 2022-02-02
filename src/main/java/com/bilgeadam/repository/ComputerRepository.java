package com.bilgeadam.repository;

import com.bilgeadam.entity.ComputerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Crud: create read update delete
//computerId datatype ==> Long
public interface ComputerRepository extends CrudRepository <ComputerEntity,Long>{
    //yeni sorgu icin lazım olacak
    //Not: Entity attribute aynı olmak zorunda ==> computerName
    //1.YOL
   // List<ComputerEntity> findComputerEntitiesByComputerName(String computerName);

    //2.YOL
    //jpql
    @Query("select c from ComputerEntity c where c.computerName= :computerName")
    List<ComputerEntity> findComputerEntitiesByComputerName( @Param("computerName") String computerName);
}
