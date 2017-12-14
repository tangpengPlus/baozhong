
/**
 * Created by Administrator on 2017/11/23.
 */
var vueData = {};
vueData.citylist = [];
//1省列表  2市 ...
vueData.dengji = 1;
//暂存选择列表

vueData.selectList =[];
var example = new Vue({
    el: '.container',
    data: vueData,
    methods: {
        getlist: function (k, name) {
        	console.log(k);
        	console.log('dengji:'+this.dengji);
        	//选择了街道之后 把id传递回去
        	if(this.dengji==5){
        		parent.getRegin(k);
        		return;
        	}
        	this.selectList[this.dengji-1]={name:name,list:vueData.citylist};
        	var obj = new jiexi();
        	obj.getNext(k);
        	//点击重置选择列表之后 保存上一级列表的数据 
        	
        },
        //点击上面的已选则 列表 回到以前的状态
        historySelect: function (his) {
        	console.log('saa');
        	this.dengji=his+1;
        	vueData.citylist=this.selectList[his].list;
        	this.selectList[3]=0;
        	//点击市 
           if(his==2){
           		this.selectList[2]=0;
           	}
           //点击省
           if(his==1){
           		this.selectList[1]=0;
           		this.selectList[2]=0;
           	}
        }
    }
});


function  jiexi(){
   
    this.getNext=function(id){
    	var url='${baes}/merchant/regionOne';
    	if(vueData.id!=0){
    		url='${baes}/merchant/regionNext';
    	}
    	var sdata={};
    	//获取省列表以外的 传入id
    	if(id!=0){
    		var sid=id;
    		sdata={"reginId":sid};
    	}
    	$.post(url,sdata,function(data){
    		//更新选择城市列表
    		vueData.dengji+=1;
    		vueData.citylist=data;
    	},'json');
    	//获取的列表等级
    	
    }
    
}

$(document).ready(function(){
    var  obj = new jiexi();
    var data = obj.getNext(0);
});



