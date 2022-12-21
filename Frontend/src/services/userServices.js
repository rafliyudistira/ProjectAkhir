import http from "../http-common";

class userServices{
    create(data){
        return http.post("/user/insert", data);
    }
    getAll(){
        return http.get("/user/getAll");
    }
    deleteUser(id){
        return http.delete(`/user/delete/${id}`);
    }
    updateUser(id, data){
        return http.put(`/user/update/${id}`, data);
    }
    getUserById(id) {
        return http.get(`/user/getData/${id}`)
    }
    login(data){
        return http.post("/user/login", data);
    }
}

export default new userServices();