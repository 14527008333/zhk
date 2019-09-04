<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>

	<form action="<%=request.getContextPath()%>/list.do" method="post">
		<input type="hidden" name="cpage">
		请输入电影名称：<input type="text" name="mname" value="${mname }">
		<input type="submit" value="查找">
	</form>
	<a href="<%=request.getContextPath()%>/toadd.do"><input type="button" value="添加"></a>
	<input type="button" value="批量删除">
	<table border="1">
		<tr>
			<td><input type="checkbox" name="quan"></td>
			<td>编号</td>
			<td>电影名称</td>
			<td>电影简介</td>
			<td>导演</td>
			<td>电影类型</td>
			<td>发布时间</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${list }" var="map">
			<tr>
				<td><input type="checkbox" name="xuan" value="${map.mid }"></td>
				<td>${map.mid }</td>
				<td>${map.mname }</td>
				<td>${map.context }</td>
				<td>${map.daoyan }</td>
				<td>${map.type }</td>
				<td>${map.startdate }</td>
				<td><input type="button" value="修改" onclick="upda(${map.mid })"> </td>
				
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="首页" onclick="page(1)">
	<input type="button" value="上一页" onclick="page(${pi.isIsFirstPage() ? 1:pi.getPrePage()}})">
	<input type="button" value="下一页" onclick="page(${pi.isIsLastPage() ? pi.getPages():pi.getNextPage()})">
	<input type="button" value="尾页" onclick="page(${pi.getPages()})">
	
	<script type="text/javascript">
		function page(cpage){
			$("[name=cpage]").val(cpage)
			$("form").submit()
		}
		function upda(mid){
			location.href="<%=request.getContextPath()%>/toupdate.do?mid="+mid
		}
		$("[name=quan]").click(function(){
			if($("[name=quan]").attr("checked")){
				$("[name=xuan]").attr("checked",true)
			
			}else{
				$("[name=xuan]").attr("checked",false)
			}
			
		})
		$("input[value='批量删除']").click(function(){
			alert("sad")
			var mids=[];
			$("[name=xuan]:checked").each(function(){
				mids.push($(this).val())
			})
			location.href="<%=request.getContextPath()%>/dels.do?mids="+mids
		})
	</script>
</body>
</html>