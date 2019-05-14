package co.uk.project.springmvc.service.impl;

import co.uk.project.springmvc.core.dao.OrdersDao;
import co.uk.project.springmvc.core.domain.Orders;
import co.uk.project.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> getAllOrdersForCustomer(Integer customerId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Enter: getAllOrdersForCustomer()");
        }

        List<Orders> allOrders = ordersDao.fetchOrdersForCustomer(customerId);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Exit: getAllOrdersForCustomer()");
        }

        return null;
    }
}
