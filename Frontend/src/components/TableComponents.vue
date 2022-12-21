<template>
    <div>
        <body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"  v-show="!succes">Data Kartu Keluarga</h1>
                    <!-- DataTales Example -->
                    <succes-form v-show="succes"/>
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
                                            <th>Nomor KK</th>
                                            <th>Alamat</th>
                                            <th>Kota</th>
                                            <th>Kode Pos</th>
                                            <th class="th">Action</th>
                                        </tr>
                                    </thead>
                        
                                    <tbody>
                                        <tr v-for="item, index in kartuData" :key="item.id">
                                            <td>{{ index + 1 }}</td>
                                            <td>{{ item.nomor_kk }}</td>
                                            <td>{{ item.alamat }}</td>
                                            <td>{{ item.kabupaten_kota }}</td>
                                            <td>{{ item.kode_pos }}</td>
                                            <td>  
                                                    <router-link :to="{ name : 'detailKK', params: {id : item.id}}" @click.prevent="$emit ('updateKartu', item)"><button class="btn btn-primary btn1">Detail</button></router-link>
                                                    <button @click.prevent="deleteKartuFunc(item.id)" class="btn btn-danger btn1">Hapus</button>
                                            </td>
                                        </tr>
                                       
                                    </tbody>
                                </table>
                                <div v-if="kartuData < 1" class="dat bg-light">Tidak ada data</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
</body>
    </div>
</template>

<script>
import kartuServices from "../services/kartuServices"
import anggotaServices from "../services/anggotaServices"
import succesForm from "../components/FormSuccess.vue"

export default {
    name : "TableComponents",
    components: {
        succesForm
    },

    methods : {
        getKartu(){
            kartuServices.getAll()
                .then(response => {
                    this.kartuData = response.data;
                    console.log(this.kartuData);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        deleteKartuFunc(id){
            if(confirm("Apakah anda yakin hapus?")){
                kartuServices.deleteKartu(id)
                    .then(response => {
                        anggotaServices.deleteAllAnggota(id)
                        console.log(response.data);
                        this.$emit('deleteEmit');
                        this.succes = true;
                        // location.reload();
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }else{
                alert("Hapus dibatalkan!")
            }
        },
        
    },
     mounted(){
        this.getKartu();
    },
    data(){
        return{
            kartuData : null,
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
    width: 80px;
    margin: 0;
    border-radius: 15px;
}
.dat {
    text-align: center;
}
.card{
    margin-left: 10px;
    width: 160vh;
}
</style>