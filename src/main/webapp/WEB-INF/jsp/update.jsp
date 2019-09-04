<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>

</head>
<body>
<form action="<%=request.getContextPath()%>/updatemove.do" method="post">
		<input type="hidden" name="mid" value="${mid }">
		请输入电影名称：<input type="text" name="mname"><br>
		请输入电影简介：<input type="text" name="context"><br>
		请输入电影导演：<input type="text" name="daoyan"><br>
		请输入发布时间：<input type="date" name="startdate"><br>
		请选择电影类型<div> </div>
		<input type="submit">
	</form>
	
	<script type="text/javascript">
		
		
		$.post("<%=request.getContextPath()%>/gettypeList.do",function(res){
			for(var i in res){
				var a=$('<input type="checkbox" name="tids" value="'+res[i].tid+'"><span>'+res[i].tname+'</span>')
				$("div").append(a)
			}
		},"json")
		var mid =$("[name=mid]").val()
		$.post("<%=request.getContextPath()%>/getmoveById.do?mid="+mid,function(res){
			$("[name=mname]").val(res.mname)
			$("[name=context]").val(res.context)
			$("[name=daoyan]").val(res.daoyan)
			$("[name=startdate]").val(res.startdate)
			var tid=res.type.split(",")
			for(var i in tid){
				$("input[value="+tid[i]+"]").attr("checked",true)
			}
		},"json")
	</script>
</body>
</html>