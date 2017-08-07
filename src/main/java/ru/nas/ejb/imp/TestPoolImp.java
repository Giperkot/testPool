package ru.nas.ejb.imp;

import ru.nas.ejb.TestPool;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import java.util.UUID;

/**
 * Created by admin on 04.08.2017.
 */

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class TestPoolImp implements TestPool {

    @PersistenceContext(unitName = "kis")
    private EntityManager em;


    public void testPool(String id) {
            Query query = em.createNativeQuery("insert into public.test_pool (id, name, count)values(?1, ?2, ?3);");
            String str = UUID.randomUUID().toString();
            query.setParameter(1, UUID.randomUUID());
            query.setParameter(2, str);
            query.setParameter(3, 1);
            query.executeUpdate();


            if (id == null) throw new RuntimeException("error test");

            query.setParameter(1, UUID.randomUUID());
            query.setParameter(2, str);
            query.setParameter(3, 2);
            query.executeUpdate();

            em.flush();

    }
}
