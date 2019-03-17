package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
	private Integer userId;
	private String userRealname;
	private String userSex;
	private String userTel;
	
	private String userAddress;
	private String userKahao;
	private float userYue;
	private String loginname;
	private String loginpw;
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	public String userAdd()
	{
		TUser user=new TUser();
		
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		user.setUserTel(userTel);
		user.setUserAddress(userAddress);
		
		user.setUserKahao(userKahao);
		user.setUserYue(userYue);
		user.setLoginname(loginname);
		user.setLoginpw(loginpw);
		
		user.setUserDel("no");
		
		userDAO.save(user);
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
		
	}
	
	
	public String userMana()
	{
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.getHibernateTemplate().update(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	public String userAll()
	{
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userDetail()
	{
		String sql="from TUser where userId="+userId;
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String chongzhi()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Float qianshu=Float.parseFloat(request.getParameter("qianshu"));
		
		TUser user=userDAO.findById(userId);
		user.setUserYue(user.getUserYue()+qianshu);
		userDAO.attachDirty(user);
		
		request.setAttribute("msg", "充值完毕");
		return "msg";
	}
	
	
	public String user_edit_user()
	{
		TUser user=userDAO.findById(userId);
		
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		user.setUserTel(userTel);
		user.setUserAddress(userAddress);
		
		user.setUserKahao(userKahao);
		user.setUserYue(userYue);
		user.setLoginname(loginname);
		user.setLoginpw(loginpw);
		
		userDAO.attachDirty(user);

		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "修改完毕，重新登录后生效");
		return "msg";
	}
	
	
	
	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getLoginname()
	{
		return loginname;
	}


	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}


	public String getLoginpw()
	{
		return loginpw;
	}


	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public String getUserAddress()
	{
		return userAddress;
	}


	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}


	public String getUserKahao()
	{
		return userKahao;
	}


	public void setUserKahao(String userKahao)
	{
		this.userKahao = userKahao;
	}


	public String getUserRealname()
	{
		return userRealname;
	}


	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}


	public String getUserSex()
	{
		return userSex;
	}


	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}


	public String getUserTel()
	{
		return userTel;
	}


	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}


	public float getUserYue()
	{
		return userYue;
	}


	public void setUserYue(float userYue)
	{
		this.userYue = userYue;
	}
	
}
