package co.uk.project.springmvc.core.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;

import javax.persistence.Query;
import javax.persistence.TemporalType;

public class BaseDao {

    private static final String MORE_THAN_ONE_RESULT_FOUND = "More than one result found";
    private static final String NO_RESULTS_FOUND = "No results found";
    protected EntityManager em;

    protected <T> List<T> namedSearch(String queryName, Map<String, Object> params) {
        EntityManager em = this.em;

        List var5;
        try {
            Query query = this.createNamedQuery(em, queryName, params);
            var5 = this.findList(query);
        } finally {
            this.safeClose(em);
        }

        return var5;
    }

    protected Query createNamedQuery(EntityManager em, String queryName, Map<String, Object> params) {
        Query query = em.createNamedQuery(queryName);
        this.createNamedParameters(query, params);
        return query;
    }

    private void createNamedParameters(Query query, Map<String, Object> params) {
        if (params != null) {
            Iterator i$ = params.entrySet().iterator();

            while(i$.hasNext()) {
                Map.Entry<String, Object> param = (Map.Entry)i$.next();
                if (param.getValue() instanceof Timestamp) {
                    query.setParameter((String)param.getKey(), (Timestamp)param.getValue(), TemporalType.TIMESTAMP);
                } else if (param.getValue() instanceof Date) {
                    query.setParameter((String)param.getKey(), (Date)param.getValue(), TemporalType.DATE);
                } else {
                    query.setParameter((String)param.getKey(), param.getValue());
                }
            }
        }

    }

    private <T> List<T> findList(Query query) {
        return query.getResultList();
    }

    protected void safeClose(EntityManager em) {
        if (em != null) {
            em.close();
        }

    }

}
