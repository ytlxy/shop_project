app.service('UserService',function ($http){
    this.findAll=function (){
        return $http.get('../api/user/findAll');
    }
    this.findByName=function (username){
        return $http.get('../api/user/findByName?username='+username);
    }
    this.findById=function (id){
        return $http.get('../api/user/findById?id='+id);
    }
    this.addUser=function (entity){
        return $http.post('../api/user/addUser'+entity);
    }
    this.updatepwd=function (entity){
        return $http.post('../api/user/updatepwd'+entity);
    }
    this.deleteUser=function (ids){
        return $http.post('../api/user/deleteUser?ids='+ids)
    }
})