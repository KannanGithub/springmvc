package co.uk.project.springmvc.web;


import co.uk.project.springmvc.core.domain.Orders;
import co.uk.project.springmvc.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private static final Logger LOG = Logger.getLogger(OrderController.class);

    private static final String GET_ALL_PHONE_NUMBERS_FOR_CUSTOMER = "/{customerId}/orders";
    private static final String CUSTOMER_ID = "customerId";

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = GET_ALL_PHONE_NUMBERS_FOR_CUSTOMER, method = RequestMethod.GET)
    public List<Orders> getAllOrdersForCustomer(@PathVariable(CUSTOMER_ID) Integer customerId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Enter: getAllOrdersForCustomer(customerId = [" + customerId + "])");
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Exit: getAllOrdersForCustomer(customerId = [" + customerId + "])");
        }

        return orderService.getAllOrdersForCustomer(customerId);
    }
}
