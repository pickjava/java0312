<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'bar.jsp' starting page</title>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>

  </head>
  
  <body>
   <div id="main" style="width: 700px;height: 600px;"></div>
   
   <script type="text/javascript">
      var myecharts=echarts.init(document.getElementById("main"));
      
      var option={
        title:{
           text:"Echarts柱状图"
       },
        xAxis:{
            data:[]
        },
        yAxis:{
            
        },
        series:[{
            name:"成绩",
            type:'bar',
            data:[]
          }]
      };
      
        myecharts.setOption(option);
        myecharts.showLoading();
        
       var names=[];
       var scores=[];
       
       $.ajax({
         type:"post",
         async:true,
         url:"getAllStudent",
         data:{},
         dataType:'json',
         success:function(res){
            if(res){
              for(var i=0;i<res.length;i++){
                 names.push(res[i].sname);
                 scores.push(res[i].score);
              }
              myecharts.hideLoading();
              myecharts.setOption({
                xAxis:{
                  data:names
                },
                series:[{
                data:scores
                 }]
              });
            }
         },
         error:function(msg){
           alert("数据加载失败！")
         }
       })
       
     
    
      
      
   </script>
   
  </body>
</html>
