import http from "../http-common";

class kartuServices{
    create(data){
        return http.post("/kartukeluarga/insert", data);
    }
    getAll(){
        return http.get("/kartukeluarga/getAll");
    }
    deleteKartu(id){
        return http.delete(`/kartukeluarga/delete/${id}`);
    }
    updateKartu(id, data){
        return http.put(`/kartukeluarga/update/${id}`, data);
    }
    getKartuById(id) {
        return http.get(`/kartukeluarga/getKartuById/${id}`)
    }
    deleteAllAnggota(id_kk) {
        return http.delete(`kartukeluarga/deleteAllAnggota/${id_kk}`)
    }
}

export default new kartuServices();