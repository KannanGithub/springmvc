package co.uk.project.springmvc.core.dao;

import co.uk.project.springmvc.core.domain.Order;

import java.util.List;

public interface OrderDao {

    List<Order> fetchOrdersForCustomer(Integer customerId);
}
