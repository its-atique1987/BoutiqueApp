package com.example.online.store.MyBoutique.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.online.store.MyBoutique.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public long countByName(String name);

	public List<Product> findByBarCodeId(String barCodeId);

}
