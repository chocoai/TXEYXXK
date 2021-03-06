﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${ctx }/resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>商品分类</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 评论管理 <span class="c-gray en">&gt;</span> 意见反馈 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入关键词" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜意见</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l">  <a class="btn btn-primary radius" href="javascript:;" onclick="addComment('添加反馈意见','${ctx}/comment/toAddComment','700','300')" ><i class="Hui-iconfont">&#xe600;</i> 录入</a> <a class="btn btn-primary radius" href="javascript:;" onclick="addComment('添加反馈意见','${ctx}/comment/toAddComment','700','300')" ><i class="Hui-iconfont">&#xe600;</i> 导出</a> </span>  
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="60">公众帐号名称 </th>
					<th width="60">公众帐号TOKEN </th>
					<th width="120">公众微信号</th>
					<th width="180">原始ID</th>
					<th width="120">公众号类型</th>
					<th width="120">电子邮箱 </th>
					<th width="120">公众帐号描述  </th>
					<th width="120">公众帐号APPID</th>
					<th width="120">公众帐号APPSECRET</th> 
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${data }" var="d">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${d.ACCOUNTNAME }</td>
					<td>${d.ACCOUNTTOKEN }</td>
					<td>${d.ACCOUNTNUMBER }</td>
					<td>${d.weixin_accountid }</td>
					<td>${d.ACCOUNTTYPE }</td>
					<td>${d.ACCOUNTEMAIL }</td>
					<td>${d.ACCOUNTDESC }</td>
					<td>${d.ACCOUNTAPPID }</td>
					<td>${d.ACCOUNTAPPSECRET }</td>
					<td>
							<a style="text-decoration:none" class="ml-5"  href="${ctx }/permission/delmenu/${d.ID}" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="${ctx }/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
});
function addComment(title,url,w,h){
	layer_show(title,url,w,h);
}

</script>
</body>
</html>