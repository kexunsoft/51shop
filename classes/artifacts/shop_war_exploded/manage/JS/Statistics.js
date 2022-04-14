var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
var str="";
var seriesstr;
$.ajax({
    url:"http://localhost:8080/shop/SerichOrdetByWeekDay",
     type:"POST",
     dataType:"TEXT",
     async: false,
     success:function(res){
    	
        str=res;
     },
		error: function (XMLHttpRequest, textStatus, errorThrown) {
                 // 状态码
                 console.log(XMLHttpRequest.status);
                 // 状态
                 console.log(XMLHttpRequest.readyState);
                 // 错误信息   
                 console.log(textStatus);
             }
   
}
);

$.ajax({
    url:"http://localhost:8080/shop/SerichGroupList",
     type:"POST",
     dataType:"json",
     async: false,
     success:function(res){
    	
    	 seriesstr=res;
     },
		error: function (XMLHttpRequest, textStatus, errorThrown) {
                 // 状态码
                 console.log(XMLHttpRequest.status);
                 // 状态
                 console.log(XMLHttpRequest.readyState);
                 // 错误信息   
                 console.log(textStatus);
             }
   
}
);

option = {
		
	 title : {
        text: '周收入统计',
        subtext: '',
        x:'center'
    },
    xAxis: {
        type: 'category',
        data: ['周日','周一', '周二', '周三', '周四', '周五', '周六']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [str.split(",")[0],str.split(",")[1],str.split(",")[2],str.split(",")[3],str.split(",")[4],str.split(",")[5],str.split(",")[6]],
        type: 'bar'
    }]
};
;

if (option && typeof option === "object") {
    myChart.setOption(option, true);
}



var doms = document.getElementById("container2");
var myChart = echarts.init(doms);
var app = {};
option = null;
option = {
    title : {
        text: '各商品收益统计',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: seriesstr.name
    },
    series : [
        {
            name: '销售总数',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:seriesstr,
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
