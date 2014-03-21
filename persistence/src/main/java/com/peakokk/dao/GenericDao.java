package com.peakokk.dao;
/*package com.findshef.dao;

import java.util.List;
import java.util.Date;

import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import security.CustomUser;
import utils.Utils;
import data.User;

@SuppressWarnings("unchecked")
public class GenericDao extends HibernateDaoSupport implements UserDetailsService {

	*//** Logger for this class and subclasses *//*
	protected final Log logger = LogFactory.getLog(getClass());

	Session session = null;
	Transaction tx = null;

	public HibernateTemplate getHibernate() {
		return getHibernateTemplate();
	}

	public synchronized Object get(Class entity, String handle) throws DataAccessException {
		Long _id = null;
		try {
			_id = Long.valueOf(handle);
		} catch (Exception e) {
			return null;
		}
		Object object = getHibernateTemplate().load(entity, _id);
		getHibernateTemplate().flush();

		return object;
	}

	
	 * public JustificationFile getFile( Class entity, String handle ) throws
	 * Exception {
	 * 
	 * session = getSession(getHibernateTemplate().isAllowCreate());
	 * 
	 * session.refresh(blobEntity,LockMode.UPGRADE); Blob blob =
	 * blobEntity.getBlobField(); blob.setBytes(...)
	 * 
	 * return object; }
	 

	public synchronized List getList(String query) throws DataAccessException {
		List itemlist = getHibernateTemplate().find(query);
		getHibernateTemplate().flush();
		return itemlist;
	}

	public synchronized List getListFromNativeSQL(String query) throws DataAccessException {
		org.hibernate.Session session = getSession();
		List list = session.createSQLQuery(query).list();
		releaseSession(session);
		return list;
	}

	public synchronized Object save(Object object) {
		try {
			session = getSession(getHibernateTemplate().isAllowCreate());
			session.setFlushMode(FlushMode.AUTO);
			tx = session.beginTransaction();

			session.saveOrUpdate(object); //don't use merge, it breaks changing roles in user editor due to one-to-one
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);
			throw new RuntimeException(e);
		}

		session.refresh(object);
		releaseSession(session);

		tx = null;
		session = null;
		return object;

	}

	public synchronized void saveList(List list) {

		try {
			session = getSession(getHibernateTemplate().isAllowCreate());
			session.setFlushMode(FlushMode.AUTO);
			tx = session.beginTransaction();

			for (Object object : list)
				session.saveOrUpdate(object); //don't use merge, it breaks changing roles in user editor due to one-to-one

			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);

			throw new RuntimeException(e);
		}

		releaseSession(session);
		tx = null;
		session = null;
	}

	public synchronized Object saveAndDelete(Object object, List deleteList) {
		try {
			session = getSession(getHibernateTemplate().isAllowCreate());
			session.setFlushMode(FlushMode.AUTO);
			tx = session.beginTransaction();

			session.saveOrUpdate(object); //don't use merge, it breaks changing roles in user editor due to one-to-one

			if (deleteList != null) {
				for (Object deleteObject : deleteList)
					getHibernateTemplate().delete(deleteObject);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);
			throw new RuntimeException(e);
		}

		session.refresh(object);
		releaseSession(session);

		tx = null;
		session = null;
		return object;

	}

	public synchronized Object refresh(Object object) {
		try {
			session = getSession(getHibernateTemplate().isAllowCreate());
			session.setFlushMode(FlushMode.AUTO);
			tx = session.beginTransaction();
			session.flush();
			session.refresh(object);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);

			throw new RuntimeException(e);
		}
		releaseSession(session);
		tx = null;
		session = null;

		return object;

	}

	public synchronized int update(String query) {
		int count = 0;
		org.hibernate.Session session = getSession(getHibernateTemplate().isAllowCreate());
		org.hibernate.Query q = session.createQuery(query);
		try {
			tx = session.beginTransaction();
			count = q.executeUpdate();
			getHibernateTemplate().flush();
			releaseSession(session);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);
			throw new RuntimeException(e);
		}

		releaseSession(session);
		tx = null;
		session = null;

		return count;
	}

	public synchronized boolean delete(Object object) {

		if (object != null) {
			// logger.warn ( " Deleting " + object );
			try {
				session = getSession(getHibernateTemplate().isAllowCreate());
				session.setFlushMode(FlushMode.AUTO);
				tx = session.beginTransaction();

				getHibernateTemplate().delete(object);
				session.flush();
				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				releaseSession(session);
				throw new RuntimeException(e);
			}
			releaseSession(session);
			tx = null;
			session = null;
			return true;
		}

		return false;
	}
	//Begin:#74:Delete duplicate order issue
	public synchronized boolean deleteHQL(long id,String query) {
		boolean flag=false;
		if (id != 0) {
			// logger.warn ( " Deleting " + object );
			try {
				session = getSession(getHibernateTemplate().isAllowCreate());
				session.setFlushMode(FlushMode.AUTO);
				tx = session.beginTransaction();
				 Query queryHql = session.createQuery(query);
				 queryHql.setLong("objectid",id);
			        int rowCount = queryHql.executeUpdate();
			        if(rowCount>0){
			        	
			        	flag=true;
			        }
			        System.out.println(rowCount+":::rowCount");
			//	getHibernateTemplate().delete(object);
				session.flush();
				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				releaseSession(session);
				throw new RuntimeException(e);
			}
			releaseSession(session);
			tx = null;
			session = null;
			return flag;
		}

		return flag;
	}
	//End:#74:Delete duplicate order issue
	public synchronized boolean deleteList(List list) {

		if (list != null) {
			// logger.warn ( " Deleting " + object );
			try {

				session = getSession(getHibernateTemplate().isAllowCreate());
				session.setFlushMode(FlushMode.AUTO);
				tx = session.beginTransaction();

				for (Object object : list)
					getHibernateTemplate().delete(object);
				session.flush();
				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				releaseSession(session);
				throw new RuntimeException(e);
			}
			releaseSession(session);
			tx = null;
			session = null;
			return true;
		}

		return false;
	}

	public synchronized UserDetails loadUserByUsername(String username) {

		session = getSession();
		//Begin:#2:Login functionality issue                                                                    
		User user = (User) session.createCriteria(User.class).add(Restrictions.ilike("username", Utils.removeWhitespaces(username))).uniqueResult();
		//System.out.println("user::::"+user.getPassword());
		//End:#2:Login functionality issue
		session.flush();
		releaseSession(session);

		if (user != null) {
			Hibernate.initialize(user.getProfile());
			if (user.getAccount()!=null) {
				Hibernate.initialize(user.getAccount().getContactProfile());
				Hibernate.initialize(user.getAccount().getBillingProfile());
			}

			user.setLoginDate(new Date());
			this.save(user);

			CustomUser uuser = new CustomUser(user);

			return uuser;
		} else if (user != null)
			throw new org.springframework.security.CredentialsExpiredException("");

		return null;
	}

	public boolean delete(Object object, StringBuffer msg) {

		if (object == null) {
			msg.append("Nothing to delete.");
			return false;
		}

		try {
			getHibernateTemplate().delete(object);
			getHibernateTemplate().flush();
		} catch (DataIntegrityViolationException e) {
			getHibernateTemplate().clear();
			msg.append("The object could not be deleted because it is referenced by other records.");
			return false;
		} catch (Exception e) {
			getHibernateTemplate().clear();
			msg.append(e.getCause().getMessage());
			logger.error(e, e);
			return false;
		}

		return true;
	}

	public void evict(Object object) {

		getHibernateTemplate().getSessionFactory().getCurrentSession().evict(object);

	}

	public void release(Session sess) {
		releaseSession(sess);
	}
	//Begin:#1:Delete OldData issue
	public synchronized int updateToInActive(String query,List objectidList) {
		int count = 0;
		
		org.hibernate.Session session = getSession(getHibernateTemplate().isAllowCreate());
		org.hibernate.Query q = session.createQuery(query);
		q.setParameterList("objectid", objectidList);

		try {
			tx = session.beginTransaction();
			count = q.executeUpdate();
			getHibernateTemplate().flush();
			releaseSession(session);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			releaseSession(session);
			throw new RuntimeException(e);
		}

		releaseSession(session);
		tx = null;
		session = null;

		return count;
	}
	//End:#1:Delete OldData issue
}
*/