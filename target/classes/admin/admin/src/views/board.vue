<template>
<div class="content box5" :style='{"minHeight":"100vh","flexWrap":"wrap","background":"#26303c","backgroundImage":"url(http://codegen.caihongy.cn/20230117/cb4855c320584f8d92211bca7817244b.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","position":"relative","height":"auto"}'>
	<!-- 标题 -->
	<div :style='{"padding":"0 0 0 3%","margin":"0 0 20px 0","color":"#fff","textAlign":"left","background":"none","width":"100%","lineHeight":"64px","fontSize":"28px","height":"64px"}'>欢迎使用 {{this.$project.projectName}}</div>
	<!-- 时间 -->
	<div :style='{"top":"0","color":"#fff","display":"inline-block","lineHeight":"64px","fontSize":"16px","position":"absolute","right":"50px","height":"64px"}' class="times">{{ dates }}</div>
	<!-- 系统简介 -->
	<div :style='{"padding":"20px","margin":"0 1% 20px 3%","flexWrap":"wrap","background":"rgba(0,0,0,.1)","flexDirection":"column","display":"flex","width":"20%","height":"400px","order":"1"}'>
		<el-carousel :style='{"width":"360px","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="card" direction="horizontal" height="220px" autoplay="true" interval="6000" loop="true">
			<el-carousel-item :style='{"borderRadius":"0","width":"50%","height":"80%"}'>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture1" :src="$base.url+ systemIntroductionDetail.picture1" fit="cover"></el-image>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture2" :src="$base.url+ systemIntroductionDetail.picture2" fit="cover"></el-image>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture3" :src="$base.url+ systemIntroductionDetail.picture3" fit="cover"></el-image>
			</el-carousel-item>
		</el-carousel>
		<div :style='{"margin":"10px 10px 5px 0","lineHeight":"1.5","fontSize":"16px","overflow":"hidden","color":"#fff","flex":1}' v-html="systemIntroductionDetail.content"></div>
	</div>
	<!-- 统计 -->
	
	<div class="echarts1">
		<div id="jiudianxinxiChart1" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts2">
		<div id="jiudianxinxiChart2" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts3">
		<div id="jiudianxinxiChart3" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts4">
		<div id="jiudianxinxiChart4" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts5">
		<div id="gonglvelanChart5" style="width:100%;height:100%;"></div>
	</div>

</div>


</template>
<script>
import * as echarts from 'echarts'
//0
//5
import router from '@/router/router-static'
export default {
	data() {
		return {
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"symbol":"emptyCircle","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"showSymbol":true,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"","shadowBlur":0,"width":2,"type":"solid","opacity":1,"shadowColor":"#000"},"symbolSize":4},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			pie: {"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
            systemIntroductionDetail: {},
			dates: '',
		};
	},
  mounted(){
    this.init();
    this.jiudianxinxiChat1();
    this.jiudianxinxiChat2();
    this.jiudianxinxiChat3();
    this.jiudianxinxiChat4();
    this.gonglvelanChat5();
  },
  created() {
    this.$nextTick(()=>{
		this.times()
	})
  },
  methods:{
    getTimeStrToDay(game_over_timestamp) {
        if (game_over_timestamp == 0)
            return "";
        var date = new Date(parseInt(game_over_timestamp));
        var now = new Date();
        var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
        var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
        var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
        let arr = ["日", "一", "二", "三", "四", "五", "六"];
        let d = arr[date.getDay()]
        return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
    },
	times() {
		setInterval(()=>{
            let date = new Date().getTime()
            this.dates = this.getTimeStrToDay(date)
		}, 1000)
	},
	filterTime(time) {
	  const date = new Date(time)
	  const Y = date.getFullYear()
	  const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
	  const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
	  
	  const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
	  const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
	  const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
	  
	  return `${Y}-${M}-${D} ${H}:${I}:${S}`
	},
    getSystemIntroduction() {
        this.$http({
            url: `systemintro/detail/1`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.systemIntroductionDetail = data.data
            }
        })
    },
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
        this.getSystemIntroduction();
    },


































//统计接口1
    jiudianxinxiChat1() {
      this.$nextTick(()=>{

        var jiudianxinxiChart1 = echarts.init(document.getElementById("jiudianxinxiChart1"),'macarons');
        this.$http({
            url: "jiudianxinxi/group/chengshi",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].chengshi);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].chengshi
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '城市统计'
				
				const legendObj = this.pie.legend
				
				let seriesObj = {
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				
                option = {
					backgroundColor: this.pie.backgroundColor,
					color: this.pie.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
					},
					series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                jiudianxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiudianxinxiChart1.resize();
                };
            }
        });
      })
    },

//统计接口2
    jiudianxinxiChat2() {
      this.$nextTick(()=>{

        var jiudianxinxiChart2 = echarts.init(document.getElementById("jiudianxinxiChart2"),'macarons');
        this.$http({
            url: "jiudianxinxi/typeStat/jiudianleibie/jiudianleibie",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis1 = [];
                let yAxis2 = [];
                let yAxis3 = [];
                let yAxis4 = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].jiudianleibie);
                    yAxis1.push(parseFloat((res[i].民宿)));
                    yAxis2.push(parseFloat((res[i].连锁酒店)));
                    yAxis3.push(parseFloat((res[i].快捷酒店)));
                    yAxis4.push(parseFloat((res[i].豪华酒店)));
                    pArray.push({
                        name: res[i].jiudianleibie
                    })
                }
                var option = {};
				let titleObj = this.bar.title
				titleObj.text = '酒店类别统计'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = [
					{
						name: '民宿',
						data: yAxis1,
						type: 'bar'
					},
					{
						name: '连锁酒店',
						data: yAxis2,
						type: 'bar'
					},
					{
						name: '快捷酒店',
						data: yAxis3,
						type: 'bar'
					},
					{
						name: '豪华酒店',
						data: yAxis4,
						type: 'bar'
					},
				]
				
				for (let i in seriesObj) {
				  seriesObj[i] = Object.assign(seriesObj[i] , this.bar.series)
				}
				
				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'axis'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: seriesObj,
				};
                // 使用刚指定的配置项和数据显示图表。
                jiudianxinxiChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiudianxinxiChart2.resize();
                };
            }
        });
      })
    },

//统计接口3
    jiudianxinxiChat3() {
      this.$nextTick(()=>{
        // jiudianmingcheng jiudianmingcheng
        //  shuliang

        var jiudianxinxiChart3 = echarts.init(document.getElementById("jiudianxinxiChart3"),'macarons');
        this.$http({
            url: `jiudianxinxi/value/jiudianmingcheng/shuliang`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].jiudianmingcheng);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].jiudianmingcheng
                    })
                }
                var option = {};
				let titleObj = this.bar.title
				titleObj.text = '酒店房间数统计'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'value'
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'category'
				yAxisObj.data = xAxis
				
				let seriesObj = {
						data: yAxis,
						type: 'bar'
					}
				seriesObj = Object.assign(seriesObj , this.bar.series)

				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj]
				};
                // 使用刚指定的配置项和数据显示图表。
                jiudianxinxiChart3.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiudianxinxiChart3.resize();
                };
            }
        });
      })
    },

//统计接口4
    jiudianxinxiChat4() {
      this.$nextTick(()=>{
        // fangjianleixing fangjianleixing
        //  jiage

        var jiudianxinxiChart4 = echarts.init(document.getElementById("jiudianxinxiChart4"),'macarons');
        this.$http({
            url: `jiudianxinxi/value/fangjianleixing/jiage`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].fangjianleixing);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].fangjianleixing
                    })
                }
                var option = {};
				let titleObj = this.line.title
				titleObj.text = '房间价格统计'
				
				const legendObj = this.line.legend
				
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
				
				option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj]
				};
                // 使用刚指定的配置项和数据显示图表。
                jiudianxinxiChart4.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiudianxinxiChart4.resize();
                };
            }
        });
      })
    },








//统计接口1
    gonglvelanChat5() {
      this.$nextTick(()=>{

        var gonglvelanChart5 = echarts.init(document.getElementById("gonglvelanChart5"),'macarons');
        this.$http({
            url: "gonglvelan/group/gonglvefenlei",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].gonglvefenlei);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].gonglvefenlei
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '攻略分类统计'
				
				const legendObj = this.pie.legend
				
				let seriesObj = {
					type: 'pie',
					radius: ['25%', '55%'],
					roseType: 'area',
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				
                option = {
					backgroundColor: this.pie.backgroundColor,
					color: this.pie.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
					},
					series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                gonglvelanChart5.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gonglvelanChart5.resize();
                };
            }
        });
      })
    },






















































  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	
	.box5 .echarts1 {
				padding: 20px;
				margin: 0 3% 20px 1%;
				background: rgba(0,0,0,.1);
				width: 72%;
				transition: 0.3s;
				height: 400px;
				order: 2;
			}
	.box5 .echarts2 {
				padding: 20px;
				margin: 0 1% 20px 1%;
				background: rgba(0,0,0,.1);
				width: 35%;
				transition: 0.3s;
				height: 350px;
				order: 4;
			}
	.box5 .echarts3 {
				padding: 20px;
				margin: 0 3% 20px 1%;
				background: rgba(0,0,0,.1);
				width: 35%;
				transition: 0.3s;
				height: 350px;
				order: 5;
			}
	.box5 .echarts4 {
				padding: 20px;
				margin: 0 1% 20px 3%;
				background: rgba(0,0,0,.1);
				width: 46%;
				transition: 0.3s;
				height: 350px;
				order: 6;
			}
	.box5 .echarts5 {
				padding: 20px;
				margin: 0 3% 20px 1%;
				background: rgba(0,0,0,.1);
				width: 46%;
				transition: 0.3s;
				height: 350px;
				order: 7;
			}
	
	.box5 .echarts1:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(0,0,0,.12);
				position: relative;
			}
	.box5 .echarts2:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(0,0,0,.12);
				position: relative;
			}
	.box5 .echarts3:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(0,0,0,.12);
				position: relative;
			}
	.box5 .echarts4:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(0,0,0,.12);
				position: relative;
			}
	.box5 .echarts5:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(0,0,0,.12);
				position: relative;
			}





</style>
