package com.bitozen.training.infrastructure.persistence.hibernate;

import com.bitozen.training.application.util.StringUtil;
import com.bitozen.training.domain.model.ticket.Ticket;
import com.bitozen.training.domain.model.ticket.TicketRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class TicketHibernateRepository extends HibernateRepository implements TicketRepository {

    @Override
    public void saveOrUpdate(Ticket ticket) {
        getSession().saveOrUpdate(ticket);
    }

    @Override
    public Ticket findByID(String ticketID) {
        return (Ticket) getSession()
                .createQuery("from com.bitozen.training.domain.model.ticket.Ticket where ticketID = :tid")
                .setParameter("tid", ticketID)
                .uniqueResult();
    }

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) getSession()
                .createQuery("from com.bitozen.training.domain.model.ticket.Ticket")
                .list();
    }

    @Override
    public void deleteData(Ticket ticket) {
        Query query = getSession().createQuery("delete from com.bitozen.training.domain.model.ticket.Ticket where ticketID = :tid");
        query.setParameter("tid", ticket.getTicketID());
        query.executeUpdate();
    }

    @Override
    public List<Ticket> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Ticket.class);
        if (StringUtil.hasValue(map.get("ticketID"))) {
            criteria.add(Restrictions.like("ticketID", "%" + map.get("ticketID") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("typeTicket"))) {
            criteria.add(Restrictions.eq("typeTicket", map.get("typeTicket")));
        }
        if (StringUtil.hasValue(map.get("tittleTicket"))) {
            criteria.add(Restrictions.like("tittleTicket", "%" + map.get("tittleTicket") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("statusTicket"))) {
            criteria.add(Restrictions.eq("statusTicket", map.get("statusTicket")));
        }
        if (StringUtil.hasValue(map.get("priority"))) {
            criteria.add(Restrictions.eq("priority", map.get("priority")));
        }
        if (StringUtil.hasValue(map.get("createdDate"))) {
            criteria.add(Restrictions.eq("createdDate", map.get("createdDate")));
        }
        if (StringUtil.hasValue(map.get("from")) && StringUtil.hasValue(map.get("to"))) {
            criteria.add(Restrictions.ge("createdDate", map.get("from")));
            criteria.add(Restrictions.le("createdDate", map.get("to")));
        }

        return criteria.list();
    }

}
