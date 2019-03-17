<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		
        <script language="javascript">
           function shouDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/shouDel.action?id="+id;
               }
           }
           function shouAdd()
           {
                 var url="<%=path %>/admin/shou/shouAdd.jsp";
				 window.location.href=url;
           }
           
           function userDetail(userId)
           {
				var strUrl = "<%=path %>/userDetail.action?userId="+userId;
				var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/images/tbg.gif">&nbsp;收取衣物管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="6%">序号</td>
					<td width="8%">会员信息</td>
					<td width="8%">洗衣类型</td>
					<td width="8%">衣物类型</td>
					
					<td width="8%">价格</td>
					<td width="8%">品牌</td>
					<td width="8%">颜色</td>
					<td width="10%">备注信息</td>
					
					<td width="8%">收取时间</td>
					<td width="8%">领取时间</td>
					<td width="8%">操作</td>
		        </tr>	
				<s:iterator value="#request.shouList" id="shou" status="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#sta.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" style="color: red" onclick="userDetail(<s:property value="#shou.userId"/>)">会员信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.xileixing"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.yiwuleixing"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.jiage"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.pinpai"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.yanse"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.beizhu"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.shoushi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#shou.lingshi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="shouDel(<s:property value="#shou.id"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="shouAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
