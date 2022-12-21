<template>
<div>
    <div class="container p-2">
        <div v-show="!succes" >
            <router-link class="btn btn-primary btn1" type="button" to="/Home" >Back</router-link>
            <button class="btn btn-primary btn1" v-show="upbtn" @click="upttog">Update</button>
            <router-link class="btn btn-primary btn1" type="button" v-show="title != 'Tambah'" :to="{name :'AnggotaViews'}">List</router-link>
        </div>
  <div class="row justify-content-center my-3">
     <div class="col-6 p-4 rounded border gradient-custom-3 border-primary shadow" v-show="!succes">
        <form class="form" @submit.prevent="inputKartu">
          <h3 class="text-center mb-4">{{title}} Kartu Keluarga</h3>
        <div class="row">
            <div class="form-group col-md-6">
            <label for="StudentName">Nomor Kartu Keluarga</label>
            <input v-model="kartuData.nomor_kk" type="number" class="form-control" id="StudentName" :disabled="!disable" placeholder="Nomor Kartu Keluarga">
            </div>
            <div class="form-group col-md-6">
            <label for="SoftSkill">Desa/Kelurahan</label>
            <input v-model="kartuData.desa_kelurahan" type="text" class="form-control" id="softSkill" :disabled="!disable" placeholder="Desa/Kelurahan" >
            </div>
        </div>
        <div class="row mt-3">
            <div class="form-group col-md-6">
            <label for="Rt">RT</label>
            <input v-model="kartuData.rt" type="number" class="t1 form-control"  :disabled="!disable" placeholder="RT" >
            </div>
            <div class="form-group col-md-6">
            <label for="Rw">RW</label>
            <input v-model="kartuData.rw" type="number" class="t1 form-control"  :disabled="!disable" placeholder="RW" >
            </div>
            <div class="form-group col-md-6">
            <label for="hardSkill">Kecamatan</label>
            <input v-model="kartuData.kecamatan" type="text" class=" t1 form-control" id="hardSkill" :disabled="!disable" placeholder="Kecamatan" >
            </div>
        </div>
    <div class="row mt-3">
        <div class="form-group col-md-6">
            <label for="studentEmail">Kode Pos</label>
            <input v-model="kartuData.kode_pos" type="number" class="form-control" id="studentEmail" :disabled="!disable" placeholder="Kode Pos" >
              <div class="row mt-3">
        <div class="form-group col-md-6">
            <label for="selfDescription">Alamat</label>  
        <textarea v-model="kartuData.alamat" name="text" id="selfDescription" cols="60vh" rows="4" :disabled="!disable" placeholder="Alamat"></textarea>
        </div>
    </div>
        <p class="mt-1" style="color: red" v-if="Validasi"><b>No KK Sudah Terdaftar!</b></p>
        </div>
        <div class="form-group col-md-6">
            <label for="interest">Kabupaten/Kota</label>
            <input v-model="kartuData.kabupaten_kota" type="text" class="form-control" id="" :disabled="!disable" placeholder="Kabupaten" >
        <div class="form-group col-md-6 mt-3">
            <label for="studentEmail">Provinsi</label>
            <input v-model="kartuData.provinsi" type="text" class="form-control" style="width: 505px;" id="" :disabled="!disable" placeholder="Provinsi" >
        </div>
        </div>
        
    </div>
        <button v-show="updateShow" @click="cancel" type="submit" class="btn btn-danger mt-2">Cancel</button>
        <button type="submit" v-show="title == 'Tambah'" class="btn btn-primary mt-3">{{ buttonValue }}</button>
        <button v-show="updateShow" class="btn btn-success ms-3 mt-2">{{ buttonValue }}</button>
        </form>
    </div>
</div>
</div>
<div v-show="succes"><FormSucces ></FormSucces></div>
</div>
</template>

<script>
import kartuServices from "../services/kartuServices"
import FormSucces from "./FormSuccess.vue"

export default {
    name : "AddkkComponents",
    components : {
        FormSucces,
    },
     data() {
        return {
            kartuData: {
                alamat : null,
                desa_kelurahan : null,
                kabupaten_kota : null,
                kecamatan : null,
                kode_pos : null,
                nomor_kk : null,
                provinsi : null,
                rt : null,
                rw : null
            },
            succes: false,
            buttonValue : "submit",
            disable : false,
            updateShow : false,
            upbtn : false,
            title : "Tambah",
            Validasi : false,

        };
    },
     methods: {
        inputKartu() {
           let data = this.kartuData;
           if(this.buttonValue == "submit"){
               kartuServices.create(data)
               .then(response => {
                   console.log(response.data);
                   this.succes = true;
                   this.judul = "Ditambahkan"
               })
               .catch(e => {
                //   console.log(e.response.data.trace.includes("Duplicate entry"));
                  let duplikat = e.response.data.trace.includes("Duplicate entry");
                  if(duplikat){
                    this.Validasi = true;
                  }else{
                    console.log(e);
                  }
               
               })
           }else{
               kartuServices.updateKartu(data.id, data)
               .then(response => {
                   console.log(response.data);
                   this.succes = true;
               })
               .catch(e => {
                   let duplikat = e.response.data.trace.includes("Duplicate entry");
                  if(duplikat){
                    this.Validasi = true;
                  }else{
                    console.log(e);
                  }
               })
           }
        },
        getKartuById(id){
            kartuServices.getKartuById(id)
            .then(response => {
                this.kartuData = response.data;
            })
            .catch(e => {
                console.log(e);
            })
        },
        upttog(){
            this.disable = true
            this.updateShow = true
            this.upbtn = false
        },
        cancel(){
            location.reload();
        }
    },
    props:['propsKartu'],
    mounted(){
        if(this.$route.name == 'detailKK'){
            this.getKartuById(this.$route.params.id);
            this.buttonValue = "update"
            this.title = "Update"
            this.upbtn = true
            }else if(this.title == 'Tambah'){
                this.disable = true
            }
    }
}
</script>

<style>
/*x
    DEMO STYLE
*/
   .gradient-custom-3 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
}
.col-6 {
    width: 145vh;
    margin-left: 20px;
}
.btn {
    margin-left: 20px;
}
.t1{
    width: 0px;
}
</style>