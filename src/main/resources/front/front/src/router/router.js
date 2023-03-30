import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import chengshiList from '../pages/chengshi/list'
import chengshiDetail from '../pages/chengshi/detail'
import chengshiAdd from '../pages/chengshi/add'
import gonglvefenleiList from '../pages/gonglvefenlei/list'
import gonglvefenleiDetail from '../pages/gonglvefenlei/detail'
import gonglvefenleiAdd from '../pages/gonglvefenlei/add'
import jiudianxinxiList from '../pages/jiudianxinxi/list'
import jiudianxinxiDetail from '../pages/jiudianxinxi/detail'
import jiudianxinxiAdd from '../pages/jiudianxinxi/add'
import gonglvelanList from '../pages/gonglvelan/list'
import gonglvelanDetail from '../pages/gonglvelan/detail'
import gonglvelanAdd from '../pages/gonglvelan/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'chengshi',
					component: chengshiList
				},
				{
					path: 'chengshiDetail',
					component: chengshiDetail
				},
				{
					path: 'chengshiAdd',
					component: chengshiAdd
				},
				{
					path: 'gonglvefenlei',
					component: gonglvefenleiList
				},
				{
					path: 'gonglvefenleiDetail',
					component: gonglvefenleiDetail
				},
				{
					path: 'gonglvefenleiAdd',
					component: gonglvefenleiAdd
				},
				{
					path: 'jiudianxinxi',
					component: jiudianxinxiList
				},
				{
					path: 'jiudianxinxiDetail',
					component: jiudianxinxiDetail
				},
				{
					path: 'jiudianxinxiAdd',
					component: jiudianxinxiAdd
				},
				{
					path: 'gonglvelan',
					component: gonglvelanList
				},
				{
					path: 'gonglvelanDetail',
					component: gonglvelanDetail
				},
				{
					path: 'gonglvelanAdd',
					component: gonglvelanAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
