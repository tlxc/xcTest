<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
        <script language="javascript">
		    function xiyileixingAll()
		    {
		       	var strUrl = "<%=path %>/xiyileixingAll.action";
				var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
			    if(ret==undefined)
			    {
			        ret="";
			    }
			    
			    if(ret=="")
			    {
			        alert("请选择洗衣类型");
			    }
			    else
			    {
			        loginService.get_xiyileixing(ret,callback);
			    }
		    }
		    
		    function callback(data) 
			{
				var s = data.split("###");
				var xileixing=s[0];
				var yiwuleixing=s[1];
				var jiage=s[2];
				
				document.formAdd.xileixing.value=xileixing;
				document.formAdd.yiwuleixing.value=yiwuleixing;
				document.formAdd.jiage.value=jiage;
			}
		    
		    
		    function userAll()
		    {
		       	var strUrl = "<%=path %>/userAll.action";
				var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
			    if(ret==undefined)
			    {
			        ret="";
			    }
			    
			    document.getElementById("userId").value=ret;
		    }
		    
		    function check()
		    {
		        if(document.formAdd.userId.value=="")
		        {
		            alert("请输入会员");
		            return false;
		        }
		        if(document.formAdd.xileixing.value=="")
		        {
		            alert("请输入洗衣类型");
		            return false;
		        }
		        document.formAdd.submit();
		    } 
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form action="<%=path %>/shouAdd.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>收取衣物管理</span></td>
					    </tr>
					    <tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         会员信息：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="userId" id="userId" style="width: 150px;" readonly="readonly"/>
						        <input type="button" value="选择" onclick="userAll()"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         洗衣类型：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="xileixing" style="width: 150px;" readonly="readonly"/>
						        <input type="button" value="选择" onclick="xiyileixingAll()"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         衣物类型：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="yiwuleixing" style="width: 150px;" readonly="readonly"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						               价格：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="jiage" style="width: 150px;" readonly="readonly"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						               品牌：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="pinpai" style="width: 150px;"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        颜色：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="yanse" style="width: 150px;"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        备注信息：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="beizhu" style="width: 400px;"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="button" value="提交" onclick="check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
