<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/25
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">s
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/ajaxfileupload.js"></script>
</head>
<style>
    .text-file {
        filter:alpha(opacity:0);
        opacity: 0;
        width:260px
    }
</style>
<body>

<div class="container">



    <form action="" name="" method="post" enctype="multipart/form-data" >
        <input type="file" name="upload"
               id="upload" style="height: 30px;width: 70px;" onchange="new WLFWQ().upLoadFile();
" class="text-file">
        <input type="button" class="btn btn-info btn-primary btn-sm CanUpd botton-box-zsgc" style="margin-top:-53px;height: 30px;width: 70px;" value="批量导入">
    </form>













    <button onclick="c()">获取</button>


    <table class="table">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>password</th>
            <th>number</th>
        </tr>

    </table>
</div>


<script>
   function c() {
       $.ajax({
           type: 'post',
           url: '/movie/customer/level',
           dataType: 'json',
           success:function(data){
               var item;
               $.each(data,function(i,result){
                   item=
                       "<tr><td>"+result['id']+"</td><td>"+result['name']+"</td><td>"+result['password']+"</td><td>"+result['number']+"</td></tr>";
                   $('.table').append(item);
               });
           },
       });
   } ;

   WLFWQ.prototype.upLoadFile = function(){
       $.ajaxFileUpload({
           url: "/movie/save",  //用于文件上传的服务器端请求地址
           secureuri: false,                                //一般设置为false
           fileElementId: "upload",            //文件上传空间的id属性  <input type="file" id="file" name="file" />
           dataType: "json",
       });
   }
</script>


</body>
</html>
