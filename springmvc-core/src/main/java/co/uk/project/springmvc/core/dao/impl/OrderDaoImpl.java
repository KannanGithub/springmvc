package co.uk.project.springmvc.core.dao.impl;

import co.uk.project.springmvc.core.dao.BaseDao;
import co.uk.project.springmvc.core.dao.OrderDao;
import co.uk.project.springmvc.core.domain.Order;
import co.uk.project.springmvc.core.exception.FatalException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public List<Order> fetchOrdersForCustomer(Integer customerId) {
        if(customerId == null) {
            throw new FatalException("CustomerId cannot be null");
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);
        return namedSearch("Order.findByCustomerId", params);
    }
}
