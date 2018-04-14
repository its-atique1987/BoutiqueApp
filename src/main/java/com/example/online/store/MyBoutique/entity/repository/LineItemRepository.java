package com.example.online.store.MyBoutique.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.online.store.MyBoutique.entity.LineItem;

@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Long> {
	
	public List<LineItem> findByProduct_id(long prodId);

}
