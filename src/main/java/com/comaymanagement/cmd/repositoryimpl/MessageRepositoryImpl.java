package com.comaymanagement.cmd.repositoryimpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comaymanagement.cmd.repository.MessageRepository;

@Repository
@Transactional(rollbackFor = Exception.class)
public class MessageRepositoryImpl implements MessageRepository{
	private static final Logger LOGGER = LoggerFactory.getLogger(PositionRepositoryImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String getMessage(Integer id) {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT description FROM messages where id = :id";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id",id);
			message = (String) query.getSingleResult();
		} catch (Exception e) {
			LOGGER.error("Error has occured in MessageRepositoryImpl at getMessage() ", e);
		}
		return message;
	}
	@Override
	public String getMessageByItemCode(String itemCode) {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT description FROM messages where itemCode = :itemCode";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("itemCode",itemCode);
			message = (String) query.getSingleResult();
		} catch (Exception e) {
			LOGGER.error("Error has occured in MessageRepositoryImpl at getMessage() ", e);
		}
		return message;
	}
	
}
