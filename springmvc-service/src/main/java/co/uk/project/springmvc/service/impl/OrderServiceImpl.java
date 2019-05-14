package co.uk.project.springmvc.service.impl;

import co.uk.project.springmvc.core.dao.OrderDao;
import co.uk.project.springmvc.core.domain.Order;
import co.uk.project.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrdersForCustomer(Integer customerId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Enter: getAllOrdersForCustomer()");
        }

        List<Order> allOrders = orderDao.fetchOrdersForCustomer(customerId);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Exit: getAllOrdersForCustomer()");
        }

        return null;
    }
}
