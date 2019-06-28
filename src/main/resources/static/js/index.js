var app=new Vue({
    el:"#search-container",
    data:{
        searchList:[],
        searchInput:""
    },
    methods:{
        /*获取最近搜索关键字*/
        getRecentlySearch:function () {
            console.log(this.searchInput)
            var that=this;
            $.ajax({
                url:"/getRecentlySearch",
                type:"post",
                success:function (res) {

                    that.searchList=res.data
                }
            })
        }
    },
    created:function () {
        this.getRecentlySearch();
    }
})