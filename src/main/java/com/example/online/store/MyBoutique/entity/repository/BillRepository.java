package com.example.online.store.MyBoutique.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.online.store.MyBoutique.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

}
