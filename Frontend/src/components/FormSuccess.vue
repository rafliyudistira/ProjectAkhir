<template>
  <div class="cards p-4" style="background-color:#f0f5f5">
    <div class="card-body " >
      <h5 class="card-title" style="color: blue;"><b>Sukses!</b></h5>
      <p class="card-text">Data telah di {{ Judul }} !</p>
      <button class="btn btn-primary"  @click="$router.go(-1)" v-if="Judul === 'Submit'">Back
      </button>
      <button class="btn btn-primary"  @click="$router.go(-1)" v-else-if="Judul === 'Update'">Back
      </button>
      <button class="btn btn-primary" @click="RefreshFunc" v-else>Refresh</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormSucces",
  data() {
    return {
      Judul: null,
    };
  },
  methods: {
    ubahJudul() {
      let route = this.$route.name;
      if (route === "AddkkViews" || route === "tambahanggota") {
        this.Judul = "Submit";
      } else if (route === "HomeViews" || route === "AnggotaViews"){
        this.Judul = "Delete";
      }else{
        this.Judul = "Update";
      }
    },
    
    RefreshFunc() {
      location.reload();
    },
  },
  mounted() {
    this.ubahJudul();
  },
};
</script>

<style scoped>
.back {
  margin-left: 9rem;
}
.border-color-pink {
  border: solid 2px #f9cada;
}
.bg-color-pink {
  background-color: #f9cada;
}
.cards {
  border-radius: 20px;
  border: 1px solid #f0f5f5;
  margin-top: 20px;
  padding-left: 50px;
  padding-right: 50px;
  width: 400px;
  margin: auto;
  float: none;
  margin-bottom: 10px;
}
.back {
  margin: auto;
}
</style>