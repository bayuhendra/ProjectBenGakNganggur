package com.bitozen.training.infrastructure.persistence.hibernate;

import com.bitozen.training.application.util.StringUtil;
import com.bitozen.training.domain.model.pelayanan.Pelayanan;
import com.bitozen.training.domain.model.pelayanan.PelayananRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 10991001
 */
@Repository
@Transactional
public class PelayananHibernateRepository extends HibernateRepository implements PelayananRepository {

    @Override
    public void SaveOrUpdate(Pelayanan pelayanan) {
        getSession().saveOrUpdate(pelayanan);
    }

    @Override
    public void deleteData(Pelayanan pelayanan) {
        Query query = getSession().createQuery("delete from com.bitozen.training.domain.model.pelayanan.Pelayanan where layananID = :tid");
        query.setParameter("tid", pelayanan.getLayananID());
        query.executeUpdate();
    }

    @Override
    public Pelayanan findByID(String pelayananID) {
        return (Pelayanan) getSession()
                .createQuery("from com.bitozen.training.domain.model.pelayanan.Pelayanan where layananID= :tid")
                .setParameter("tid", pelayananID)
                .uniqueResult();
    }

    @Override
    public List<Pelayanan> findAll() {
        return (List<Pelayanan>) getSession()
                .createQuery("from com.bitozen.training.domain.model.pelayanan.Pelayanan")
                .list();
    }

    @Override
    public List<Pelayanan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Pelayanan.class);
        if (StringUtil.hasValue(map.get("layananID"))) {
            criteria.add(Restrictions.like("layananID", "%" + map.get("layananID") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("namaLayanan"))) {
            criteria.add(Restrictions.like("namaLayanan", "%" + map.get("namaLayanan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }
        return criteria.list();
    }
}
