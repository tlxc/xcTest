package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXiyileixingDAO;
import com.model.TXiyileixing;
import com.opensymphony.xwork2.ActionSupport;

public class xiyileixingAction extends ActionSupport
{
	private Integer id;
	private String xileixing;
	private String yiwuleixing;
	private float jiage;
	
	private String message;
	private String path;
	
	private TXiyileixingDAO xiyileixingDAO;
	
	
	
	public String xiyileixingAdd()
	{
		TXiyileixing xiyileixing=new TXiyileixing();
		
		xiyileixing.setXileixing(xileixing);
		xiyileixing.setYiwuleixing(yiwuleixing);
		xiyileixing.setJiage(jiage);
		
		
		xiyileixingDAO.save(xiyileixing);
		this.setMessage("操作成功");
		this.setPath("xiyileixingMana.action");
		return "succeed";
	}
	
	public String xiyileixingMana()
	{
		String sql="from TXiyileixing order by xileixing";
		List xiyileixingList=xiyileixingDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiyileixingList", xiyileixingList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xiyileixingDel()
	{
		
		TXiyileixing xiyileixing=xiyileixingDAO.findById(id);
		xiyileixingDAO.delete(xiyileixing);
		this.setMessage("操作成功");
		this.setPath("xiyileixingMana.action");
		return "succeed";
	}
	
	
	public String xiyileixingAll()
	{
		String sql="from TXiyileixing order by xileixing";
		List xiyileixingList=xiyileixingDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiyileixingList", xiyileixingList);
		return ActionSupport.SUCCESS;
	}
	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public float getJiage()
	{
		return jiage;
	}

	public void setJiage(float jiage)
	{
		this.jiage = jiage;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}


	public String getXileixing()
	{
		return xileixing;
	}

	public void setXileixing(String xileixing)
	{
		this.xileixing = xileixing;
	}

	public TXiyileixingDAO getXiyileixingDAO()
	{
		return xiyileixingDAO;
	}

	public void setXiyileixingDAO(TXiyileixingDAO xiyileixingDAO)
	{
		this.xiyileixingDAO = xiyileixingDAO;
	}

	public String getYiwuleixing()
	{
		return yiwuleixing;
	}

	public void setYiwuleixing(String yiwuleixing)
	{
		this.yiwuleixing = yiwuleixing;
	}

}
