app.service('shopService',function ($http){
    this.findAll=function (){
        return $http.get('../api/shop/findAll');
    }
    this.findById=function (id){
        return $http.get('../api/shop/findById?id='+id);
    }
    this.findPage=function (page,size){
        return $http.get('../api/shop/'+page+'/'+size+'/findPage');
    }
    this.findEdit=function (entity){
        return $http.post('../api/shop/findEdit'+entity);
    }
    this.addShop=function (entity){
        return $http.post('../api/shop/addShop'+entity);
    }
    this.deleteShop=function (ids){
        return $http.post('../api/shop/deleteShop?ids='+ids);
    }
})