package co.uk.project.springmvc.core.dao.impl;

import co.uk.project.springmvc.core.dao.BaseDao;
import co.uk.project.springmvc.core.dao.OrdersDao;
import co.uk.project.springmvc.core.domain.Orders;
import co.uk.project.springmvc.core.exception.FatalException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdersDaoImpl extends BaseDao implements OrdersDao {

    @Override
    public List<Orders> fetchOrdersForCustomer(Integer customerId) {
        if(customerId == null) {
            throw new FatalException("CustomerId cannot be null");
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);
        return namedSearch("Orders.findByOrderNumber", params);
    }
}
