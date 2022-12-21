<template>
    <div>
        <body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
                <!-- Begin Page Content -->
                <div class="container-fluid" v-show="!succes">
                     <router-link class="btn btn-primary shadow btn1"  type="button" :to="{ name : 'detailKK'}">Back</router-link>
                      <router-link class="btn btn-primary shadow btn1"  type="button" :to="{ name : 'tambahanggota'}">Tambah</router-link>
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800 mt-3">List Anggota Keluarga</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4" v-show="!succes">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabel</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>NIK</th>
                                            <th>Nama</th>
                                            <th>Jenis Kelamin</th>
                                            <th>Kepala Keluarga</th>
                                            <th class="th">Action</th>
                                        </tr>
                                    </thead>
                        
                                    <tbody>
                                        <tr v-for="item, index in anggotaData" :key="item.id">
                                            <td>{{ index + 1 }}</td>
                                            <td>{{ item.nik }}</td>
                                            <td>{{ item.nama }}</td>
                                            <td>{{ item.jenis_kelamin }}</td>
                                            <td>{{ item.kepala_keluarga }}</td>
                                            <td>  
                                                    <router-link :to="{ name : 'detailAK', params: {id : item.id, id_kk: $route.params.id}}" @click.prevent="$emit ('updateAnggota', item)"><button class="btn btn-primary btn1">Detail</button></router-link>
                                                    <button @click.prevent="deleteAnggotaFunc(item.id)" class="btn btn-danger btn1">Hapus</button>
                                            </td>
                                        </tr>
                                       
                                    </tbody>
                                </table>
                                <div v-if="anggotaData < 1" class="dat bg-light">Tidak ada data</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
                <succes-form v-show="succes"/>
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
</body>
    </div>
</template>

<script>
import anggotaServices from "../services/anggotaServices"
import succesForm from "../components/FormSuccess.vue"

export default {
    name : "ListakComponents",
    components: {
        succesForm,
    },

    methods : {
        getAnggota(){
            anggotaServices.getAll()
                .then(response => {
                    this.anggotaData = response.data;
                    console.log(this.anggotaData);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        getIdKk(id_kk){
            anggotaServices.getIdKk(id_kk)
            .then(response => {
                this.anggotaData = response.data;
            })
            .catch(e => {
                console.log(e);
            })
        },
        deleteAnggotaFunc(id){
            let scope = this;
            if(confirm("Apakah anda yakin hapus?")){
                anggotaServices.deleteAnggota(id)
                    .then(response => {
                        console.log(response.data);
                        scope.$emit('deleteEmit');
                        this.succes = true;
                    })
                    .catch(e => {
                        console.log(e);
                    });
                // location.reload();
            }else{
                alert("Hapus dibatalkan!")
            }
        },
    },

   
     mounted(){
         if(this.$route.name == 'listanggota'){
             this.getAnggota();
         } else {
             this.getIdKk(this.$route.params.id)
         }
    },
    data(){
        return{
            anggotaData : null,
            succes : false
        }
    },
}
</script>

<style>
.th {
    width: 260px;
}
.btn {
    width: 90px;
    margin: 0;
    border-radius: 15px;
}
.dat {
    text-align: center;
}
</style>