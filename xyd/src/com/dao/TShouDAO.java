package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShou;

/**
 * Data access object (DAO) for domain model class TShou.
 * 
 * @see com.model.TShou
 * @author MyEclipse Persistence Tools
 */

public class TShouDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShouDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShou transientInstance)
	{
		log.debug("saving TShou instance");
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

	public void delete(TShou persistentInstance)
	{
		log.debug("deleting TShou instance");
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

	public TShou findById(java.lang.Integer id)
	{
		log.debug("getting TShou instance with id: " + id);
		try
		{
			TShou instance = (TShou) getHibernateTemplate().get(
					"com.model.TShou", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShou instance)
	{
		log.debug("finding TShou instance by example");
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
		log.debug("finding TShou instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShou as model where model."
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
		log.debug("finding all TShou instances");
		try
		{
			String queryString = "from TShou";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShou merge(TShou detachedInstance)
	{
		log.debug("merging TShou instance");
		try
		{
			TShou result = (TShou) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShou instance)
	{
		log.debug("attaching dirty TShou instance");
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

	public void attachClean(TShou instance)
	{
		log.debug("attaching clean TShou instance");
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

	public static TShouDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShouDAO) ctx.getBean("TShouDAO");
	}
}