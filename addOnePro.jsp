<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/5/2019
  Time: 下午 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="add.do">
    <div class="form-group">
        <label for="proName">商品名</label>
        <input type="text" class="form-control" id="proName" placeholder="商品名" name="proName">
    </div>
    <div class="form-group">
        <label for="proPrice">商品价格</label>
        <input type="number" class="form-control" id="proPrice" placeholder="商品价格" min="1.00" max="999999.00" name="proPrice">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">选择图片</label>
        <input type="file" id="exampleInputFile" name="file1">
        <p class="help-block">请选择图片</p>
    </div>
    <div class="form-group">
        <label for="proDes">商品详情</label>
        <br />
        <textarea placeholder="请输入商品详细信息" style="width: 100%;" id="proDes" name="proDes"></textarea>
    </div>
    <div class="form-group">
        <label for="proStock">商品库存</label>
        <input type="number" class="form-control" id="proStock" placeholder="商品库存" min="0" max="9999" name="proStock">
    </div>
    <div class="form-group">
        <label for="proDate">商品上架日期</label>
        <input type="date" class="form-control" id="proDate" placeholder="商品上架日期" name="proDate">
    </div>
    <div class="form-group">
        <label for="proCateId">类别ID</label>
        <input type="number" class="form-control" id="proCateId" placeholder="类别ID" min="1" max="999" name="proCateId">
    </div>
    <div class="form-group">
        <label for="proFac">生产厂家</label>
        <input type="text" class="form-control" id="proFac" placeholder="生产厂家" name="proFac">
    </div>
    <button type="submit" class="btn btn-default">确认提交</button>
</form>
</body>
</html>
