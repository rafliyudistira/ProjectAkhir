<template>
  <div class="box">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Homepage</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card-4 border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2 mt-3 mb-3">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Jumlah KK</div>
                                                <div class="d-flex">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{kartuData.length}}</div>
                                                     <div class="col mt-2 ms-3">
                                                    <div class="progress progress-sm mr-2">
                                                        <div class="progress-bar bg-primary" :style="{'width' : kartuData.length + '%'}"  role="progressbar"
                                                            aria-valuenow="50" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                                </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                       <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card-4 border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2 mt-3 mb-3">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Jumlah WARGA</div>
                                                <div class="d-flex">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{anggotaData.length}}</div>
                                                     <div class="col mt-2 ms-3">
                                                    <div class="progress progress-sm mr-2">
                                                        <div class="progress-bar bg-success" :style="{'width' : anggotaData.length + '%'}"  role="progressbar"
                                                            aria-valuenow="50" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                                </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>
</template>

<script>
import kartuServices from "../services/kartuServices"
import anggotaServices from"../services/anggotaServices"

export default {
    name : "BoxComponents",
    components : kartuServices,

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
        deleteKartuFunc(id){
            let scope = this;
            
            if(confirm("Apakah anda yakin hapus?")){
                kartuServices.deleteKartu(id)
                    .then(response => {
                        console.log(response.data);
                        scope.$emit('deleteEmit');
                        // this.succes = true;
                    })
                    .catch(e => {
                        console.log(e);
                    });
                // location.reload();
            }else{
                alert("Hapus dibatalkan!")
            }
        }
    },
    mounted(){
        this.getKartu();
        this.getAnggota();
    },
    data(){
        return{
            kartuData : [],
            anggotaData : null,
        }
    }
}
</script>

<style>
.box {
    margin-left: 20px;
}
.card {
    border-radius: 20px;
}
.h5 {
    font-size: 30px;
}
.card-4{
    width: 270px;
    border-radius: 20px;
    padding: 30px;
}
</style>