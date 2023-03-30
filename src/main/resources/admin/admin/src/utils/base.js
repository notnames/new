const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootu1xmu/",
            name: "springbootu1xmu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootu1xmu/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于大数据的酒店推荐系统"
        } 
    }
}
export default base
