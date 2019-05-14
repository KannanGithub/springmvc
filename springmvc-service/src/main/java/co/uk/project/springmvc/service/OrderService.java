package co.uk.project.springmvc.service;

import co.uk.project.springmvc.core.domain.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> getAllOrdersForCustomer(Integer customerId);
}
