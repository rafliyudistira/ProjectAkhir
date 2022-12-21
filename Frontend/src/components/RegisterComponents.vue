<template>
  <div>
  <div class="mask d-flex align-items-center gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card mt-5 mb-5 w-100" style="border-radius: 20px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-3">Daftar</h2>
              <form class="form" @submit.prevent="register">
                <div class="form-outline mb-1">
                    <label class="form-label" for="form3Example1cg">Nama Lengkap</label>
                  <input v-model="dataRegister.nama" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                </div>

                <div class="form-outline mb-1">
                    <label class="form-label" for="form3Example3cg">Email</label>
                  <input v-model="dataRegister.email" type="email" id="form3Example3cg" class="form-control form-control-lg" />
                </div>

                <div class="form-outline mb-1">
                    <label class="form-label" for="form3Example4cg">Password</label>
                  <input v-model="dataRegister.password" type="password" id="form3Example4cg" class="form-control form-control-lg" />
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form3Example4cdg">Repeat password</label>
                  <input v-model="password2" type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                </div>

                <p v-if="registerSuccess" style="color: blue;"><b>Berhasil Daftar!, Silahkan Login</b></p>
                <p v-if="emailValid" style="color: red;"><b>Email Sudah Digunakan!</b></p>
                <p v-if="passwordValid" style="color: red;"><b>Password Tidak Sama!</b></p>

                <div class="d-flex justify-content-center mt-2">
                  <button type="submit"
                    class="btn btn-primary btn-lg">Daftar</button>
                </div>

                <p class="text-center text-muted mt-3 mb-0">Sudah punya akun? <router-link to="/"
                    class="fw-bold text-primary"><u>Login disini</u></router-link></p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import userService from "@/services/userServices"
export default {
    name : 'RegisterComponents',
    data(){
      return{
        dataRegister: {
          nama: null,
          email: null,
          password: null
        },
        password2: "",
        registerSuccess: false,
        emailValid: false,
        passwordValid: false
      }
    }, 
    methods: {
      register(){
        let data = this.dataRegister;
        let password1 = data.password;
        let password2 = this.password2;

        this.registerSuccess = false;
        this.emailValid = false;
        this.passwordValid = false;
        if(password1 == password2){
          userService.create(data).then(response => {
      
            console.log(response);
            this.dataRegister = {};
            this.password2 = "";
            this.registerSuccess = true;
            // l
          }).catch(e => {
            console.log(e);
            if(e.response.data.status === 500){
            
              this.emailValid = true;
            }
          })
        } else{
          // location.reload();
          this.passwordValid = true;

        }

      }
    }
}
</script>

<style scoped>
    .gradient-custom-3 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
}
.gradient-custom-4 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}
.card {
    width: 600px;
    height: 600px;
}
.form {
    height: 550px;
}
.mask {
    height: 790px;
}
.btn {
    width: 550px;
}
</style>
