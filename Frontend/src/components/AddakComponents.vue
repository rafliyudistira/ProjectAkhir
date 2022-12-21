<template>
<div>
    <div class="container p-2">
  <button class="btn btn-primary btn1" type="button" v-show="!succes" @click="$router.go(-1)">Back</button>
  <button class="btn btn-primary btn1" v-show="upbtn" @click="upttog">Update</button>
  <div class="row justify-content-center my-3">
     <div class="col-6 p-4 rounded border gradient-custom-3 border-primary shadow" v-show="!succes"  >
        <form class="form" @submit.prevent="inputAnggota">
          <h3 class="text-center mb-4">{{title}} Anggota Keluarga</h3>
        <div class="row">
            <div class="form-group col-md-6">
            <label for="NIK">NIK</label>
            <input v-model="anggotaData.nik" type="number" class="form-control" id="NIK" :disabled="!disable" placeholder="NIK">
            </div>
            <div class="form-group col-md-6">
            <label for="SoftSkill">Tanggal Lahir</label>
            <input v-model="anggotaData.tanggal_lahir" type="date" class="form-control" id="softSkill" :disabled="!disable" placeholder="Tanggal Lahir" >
            </div>
        </div>
        <div class="row mt-3">
            <div class="form-group col-md-6">
            <label for="StudentAge">Nama Lengkap</label>
            <input v-model="anggotaData.nama" type="text" class="form-control" id="StudentAge" :disabled="!disable" placeholder="Nama Lengkap" >
            </div>
           
            <div class="form-group col-md-6">
            <label for="hardSkill">Agama</label>
            <input v-model="anggotaData.agama" type="text" class="form-control" id="hardSkill" :disabled="!disable" placeholder="Agama" >
            </div>
        </div>
    <div class="row mt-3">
        <div class="form-group col-md-6">
            <label for="studentEmail">Jenis Kelamin</label>
           <select v-model="anggotaData.jenis_kelamin" type="text" :disabled="!disable" class="form-control">
                <option selected disabled value="">Choose...</option>
                <option>Laki-laki</option>
                <option>Perempuan</option>
            </select>
              <div class="row mt-3">
        <div class="cs form-group col-md-6">
            <label for="selfDescription">Tempat Lahir</label>  
        <input v-model="anggotaData.tempat_lahir" type="text" class="form-control" id="tl" :disabled="!disable" placeholder="Tempat Lahir" >
        </div>
        <p class="mt-3" style="color: red" v-if="ValidNik"><b>Nomor NIK Sudah Terdaftar!</b></p>
    </div>
        </div>
        <div class="form-group col-md-6">
            <label for="interest">Pendidikan</label>
           <select v-model="anggotaData.pendidikan" type="text" :disabled="!disable" class="form-control">
                <option selected disabled value="">Choose...</option>
                <option>SD</option>
                <option>SMP</option>
                <option>SMA</option>
                <option>D3</option>
                <option>S1</option>
                <option>S2</option>
                <option>S3</option>
            </select>
        <div class="form-group col-md-6 mt-3">
            <label for="studentEmail">Kepala Keluarga</label>
            <!-- <input v-model="anggotaData.kepala_keluarga" type="text" class="form-control" style="width: 540px;" id="studentEmail" :disabled="!disable" placeholder="Kepala Keluarga" > -->
             <select v-model="anggotaData.kepala_keluarga" type="text" :disabled="!disable" class="form-control">
                <option selected disabled value="">Choose...</option>
                <option>Yes</option>
                <option>No</option>
            </select>
        </div>
        </div>
        
    </div>
    <div class="mt-3">
        <button v-show="updateShow" @click="cancel" type="button" class="btn btn-danger">Cancel</button>
        <button type="submit" v-show="title == 'Tambah'" class="btn btn-primary mt-3" @click="getak">{{ buttonValue }}</button>
        <button v-show="updateShow" @click="inputAnggota" class="btn btn-success ms-2">{{ buttonValue }}</button>
    </div>
        </form>
    </div>
</div>
</div>
<div v-show="succes"><FormSucces ></FormSucces></div>
</div>
</template>

<script>
import anggotaServices from "../services/anggotaServices"
import FormSucces from "../components/FormSuccess.vue"
export default {
    name : "AddakComponents",
     components : {
        FormSucces,
    },
     data() {
        return {
            anggotaData: {
                agama : null,
                id_kk : null,
                jenis_kelamin : "",
                kepala_keluarga : "",
                nama : null,
                nik : null,
                pendidikan : "",
                tanggal_lahir : null,
                tempat_lahir : null
            },
            succes: false,
            buttonValue : "submit",
            disable : false,
            updateShow : false,
            upbtn : false,
            title : "Tambah",
            ValidNik : false,

        };
    },
     methods: {
        inputAnggota() {
            this.getak();
           let data = this.anggotaData;
           if(this.buttonValue == "submit"){
               anggotaServices.create(data)
               .then(response => {
                   console.log(response.data);
                   this.succes = true;
                   this.judul = "Ditambahkan"
               })
               .catch(e => {
                // console.log(e.response.data.trace.includes("Duplicate entry"));
                let duplikasi = e.response.data.trace.includes("Duplicate entry");
                if (duplikasi){
                    this.ValidNik = true;
                }else{
                    console.log(e);
                }
                
               })
           }else{
            this.anggotaData.id_kk = this.$route.params.id_kk;
               anggotaServices.updateAnggota(data.id, data)
               .then(response => {
                   console.log(response.data);
                   this.succes = true;
               })
               .catch(e => {
                   let duplikasi = e.response.data.trace.includes("Duplicate entry");
                if (duplikasi){
                    this.ValidNik = true;
                }else{
                    console.log(e);
                }
               })
           }
        },
        getAnggotaById(id){
            anggotaServices.getAnggotaById(id)
            .then(response => {
                this.anggotaData = response.data;
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
        },

        getak(){
        this.anggotaData.id_kk = this.$route.params.id
        },
    },
    props:['propsAnggota'],
    mounted(){
        if(this.$route.name == 'detailAK'){
            this.getAnggotaById(this.$route.params.id);
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
/*
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
.btn1 {
    margin-left: 20px;
}
.btn {
    
}
.cs {
    width: 560px;
}
.form-control{
    width: 500px;
}
</style>