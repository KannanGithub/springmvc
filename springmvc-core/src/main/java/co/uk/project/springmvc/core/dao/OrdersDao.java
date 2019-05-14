package co.uk.project.springmvc.core.dao;

import co.uk.project.springmvc.core.domain.Orders;

import java.util.List;

public interface OrdersDao {

    List<Orders> fetchOrdersForCustomer(Integer customerId);
}
