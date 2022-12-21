import http from "../http-common";

class anggotaServices{
    create(data){
        return http.post("/anggotakeluarga/insert", data);
    }
    getAll(){
        return http.get("/anggotakeluarga/getAll");
    }
    deleteAnggota(id){
        return http.delete(`/anggotakeluarga/delete/${id}`);
    }
    updateAnggota(id, data){
        return http.put(`/anggotakeluarga/update/${id}`, data);
    }
    getIdKk(id_kk) {
        return http.get(`/anggotakeluarga/getIdKk/${id_kk}`)
    }
    getAnggotaById(id) {
        return http.get(`/anggotakeluarga/getAnggotaById/${id}`)
    }
    deleteAllAnggota(id_kk) {
        return http.delete(`anggotakeluarga/deleteAllAnggota/${id_kk}`)
    }
}

export default new anggotaServices();