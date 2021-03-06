package com.au.OrderManagement.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.OrderManagement.model.Order;


@Repository
public interface OrderRepository extends MongoRepository<Order , String>
{

}
