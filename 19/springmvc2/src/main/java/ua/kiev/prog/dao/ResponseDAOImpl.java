package ua.kiev.prog.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.model.AnswerAndCount;
import ua.kiev.prog.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSetMetaData;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 05.06.2018.
 */
@Component
@Transactional
public class ResponseDAOImpl implements ResponseDAO {
    @PersistenceContext
    public EntityManager em;

    @Override
    @Transactional
    public void addResponse(Response response) {
        em.persist(response);
    }

    @Override
    public List<Response> getAll() {
        TypedQuery<Response> query = em.createQuery("select r from Response r", Response.class);
        return query.getResultList();
    }

    @Override
    public List<AnswerAndCount> getQuestion1Responses() {
        return getQuestionNResponses(1);
    }

    @Override
    public List<AnswerAndCount> getQuestion2Responses() {
        return getQuestionNResponses(2);
    }

    public List<AnswerAndCount> getQuestionNResponses(int numberOfQuestion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AnswerAndCount> query = cb.createQuery(AnswerAndCount.class);
        Root<Response> r = query.from(Response.class);
        query.multiselect(r.get("answer" + numberOfQuestion), cb.count(r.get("answer" + numberOfQuestion)));
        query.groupBy(r.get("answer" + numberOfQuestion));
        List<AnswerAndCount> list = em.createQuery(query).getResultList();
        return list;
    }

    @Override
    public Response getById(long id) {
        TypedQuery<Response> query;
        query = em.createQuery("select r from Response r where r.id = :id", Response.class);
        return query.getSingleResult();
    }

    @Override
    public Response getByUserName(String userName) {
        TypedQuery<Response> query;
        query = em.createQuery("select r from Response r where r.loginName = :userName", Response.class);
        query.setParameter("userName", userName);
        List<Response> responses = query.getResultList();
        if (responses.size() > 0) {
            return responses.get(0);
        } else {
            return null;
        }
    }
}
