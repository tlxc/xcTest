package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TShouDAO;
import com.dao.TUserDAO;
import com.dao.TXiyileixingDAO;
import com.model.TShou;
import com.model.TUser;
import com.model.TXiyileixing;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class shouAction extends ActionSupport
{
	private Integer id;
	private Integer userId;
	private String xileixing;
	private String yiwuleixing;

	private Float jiage;
	private String pinpai;
	private String yanse;
	private String beizhu;

	private String shoushi;
	private String lingshi;
	
	private String message;
	private String path;
	
	private TShouDAO shouDAO;
	private TUserDAO userDAO; 
	
	
	
	public String shouAdd()
	{
		TShou shou=new TShou();
		
		shou.setUserId(userId);
		shou.setXileixing(xileixing);
		shou.setYiwuleixing(yiwuleixing);
		shou.setJiage(jiage);
		
		shou.setPinpai(pinpai);
		shou.setYanse(yanse);
		shou.setBeizhu(beizhu);
		shou.setShoushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		shou.setLingshi("");
		
		shouDAO.save(shou);
		this.setMessage("操作成功");
		this.setPath("shouMana.action");
		return "succeed";
	}
	
	public String shouMana()
	{
		String sql="from TShou where lingshi='' order by shoushi desc";
		List shouList=shouDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shouList", shouList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String shouDel()
	{
		
		TShou shou=shouDAO.findById(id);
		shouDAO.delete(shou);
		this.setMessage("操作成功");
		this.setPath("shouMana.action");
		return "succeed";
	}

	
	public String lingMana()
	{
		String sql="from TShou where lingshi='' order by shoushi desc";
		List shouList=shouDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shouList", shouList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String lingqu()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TShou shou=shouDAO.findById(id);
		int userId=shou.getUserId();
		float jiage=shou.getJiage();
		
		float userYue=userDAO.findById(userId).getUserYue();
		
		
		if(userYue<jiage)
		{
			request.put("msg", "改会员卡内余额不足，请先充值后领取");
		}
		else
		{
			shou.setLingshi(lingshi);
			shouDAO.attachDirty(shou);
			
			TUser user=userDAO.findById(userId);
			user.setUserYue(user.getUserYue()-jiage);
			userDAO.attachDirty(user);
			
			request.put("msg", "领取完毕");
		}
		
		return "msg";
	}
	
	public String tongji()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String shijian1=request.getParameter("shijian1");
		String shijian2=request.getParameter("shijian2");
		System.out.println(request.getParameter("shijian1")+"%%");
		System.out.println(request.getParameter("shijian2")+"^^");
		
		String sql="from TShou where lingshi !='' and lingshi>? and lingshi<?";
		Object[] c={shijian1,shijian2};
		List shouList=shouDAO.getHibernateTemplate().find(sql,c);
		
		request.setAttribute("shouList", shouList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String shou_mana_user()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TShou where userId="+user.getUserId();
		List shouList=shouDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shouList", shouList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Float getJiage()
	{
		return jiage;
	}

	public void setJiage(Float jiage)
	{
		this.jiage = jiage;
	}

	public String getLingshi()
	{
		return lingshi;
	}

	public void setLingshi(String lingshi)
	{
		this.lingshi = lingshi;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getPinpai()
	{
		return pinpai;
	}

	public void setPinpai(String pinpai)
	{
		this.pinpai = pinpai;
	}

	public TShouDAO getShouDAO()
	{
		return shouDAO;
	}

	public void setShouDAO(TShouDAO shouDAO)
	{
		this.shouDAO = shouDAO;
	}

	public String getShoushi()
	{
		return shoushi;
	}

	public void setShoushi(String shoushi)
	{
		this.shoushi = shoushi;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getXileixing()
	{
		return xileixing;
	}

	public void setXileixing(String xileixing)
	{
		this.xileixing = xileixing;
	}

	public String getYanse()
	{
		return yanse;
	}

	public void setYanse(String yanse)
	{
		this.yanse = yanse;
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
