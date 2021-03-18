app.service('orderService',function ($http){
    this.findAll=function (){
        return $http.get('../api/orders/findAll');
    }
    this.findById=function (id){
        return $http.get('../api/orders/findById?id='+id);
    }
    this.findPage=function (page,size){
        return $http.get('../api/orders/'+page+'/'+size+'/findPage');
    }
    this.addOrder=function (entity){
        return $http.post('../api/orders/addOrder'+entity);
    }
    this.deleteOrder=function (ids){
        return $http.post('../api/orders/deleteOrder?ids='+ids);
    }
    this.findAllMoney=function (){
        return $http.get('../api/orders/findAllMoney');
    }
})