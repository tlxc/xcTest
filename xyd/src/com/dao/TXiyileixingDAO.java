package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXiyileixing;

/**
 * Data access object (DAO) for domain model class TXiyileixing.
 * 
 * @see com.model.TXiyileixing
 * @author MyEclipse Persistence Tools
 */

public class TXiyileixingDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXiyileixingDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXiyileixing transientInstance)
	{
		log.debug("saving TXiyileixing instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TXiyileixing persistentInstance)
	{
		log.debug("deleting TXiyileixing instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TXiyileixing findById(java.lang.Integer id)
	{
		log.debug("getting TXiyileixing instance with id: " + id);
		try
		{
			TXiyileixing instance = (TXiyileixing) getHibernateTemplate().get(
					"com.model.TXiyileixing", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXiyileixing instance)
	{
		log.debug("finding TXiyileixing instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TXiyileixing instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TXiyileixing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TXiyileixing instances");
		try
		{
			String queryString = "from TXiyileixing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXiyileixing merge(TXiyileixing detachedInstance)
	{
		log.debug("merging TXiyileixing instance");
		try
		{
			TXiyileixing result = (TXiyileixing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXiyileixing instance)
	{
		log.debug("attaching dirty TXiyileixing instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TXiyileixing instance)
	{
		log.debug("attaching clean TXiyileixing instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TXiyileixingDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TXiyileixingDAO) ctx.getBean("TXiyileixingDAO");
	}
}