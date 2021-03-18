app.service('helpService',function ($http){
    this.findAll=function (){
        return $http.get('../api/help/findAll')
    }
    this.addhelp=function (entity){
        return $http.post('../api/help/addhelp'+entity);
    }
    this.deletehelp=function (ids){
        return $http.post('../api/help/deletehelp?ids='+ids);
    }
})