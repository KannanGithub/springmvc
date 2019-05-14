package co.uk.project.springmvc.service;

import co.uk.project.springmvc.core.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrdersForCustomer(Integer customerId);
}
