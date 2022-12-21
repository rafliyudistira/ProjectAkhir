<template>
    <div class="section gradient-custom-3">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="../assets/img/ktp1.png"
                    class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form @submit.prevent="login" class="form">
                        <div class="card p-5" style="border-radius: 20px;">
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mb-3">
                        <p class="lead fw-normal mb-0 me-3">Selamat Datang!</p>
                    </div>

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input v-model="dataLogin.email" type="email" id="form3Example3" class="form-control form-control-lg"
                        placeholder="Your Email" required/>
                        <label class="form-label" for="form3Example3">Email address</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input v-model="dataLogin.password" type="password" id="form3Example4" class="form-control form-control-lg"
                        placeholder="password" required/>
                        <label class="form-label" for="form3Example4">Password</label>
                    </div>
                    <p v-if="message" style="color: red;"><b>Email atau Password Salah!</b></p>
                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"  style="padding-left: 2.5rem; padding-right: 2.5rem;" >Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Belum punya akun? <router-link
                            class="link-primary" to="/Register">Daftar disini</router-link></p>
                    </div>
                    </div>
                    </form>
                </div>
                </div>
            </div>
    </div>
</template>

<script>
import userService from "@/services/userServices"

export default {
    name : 'LoginComponents',
    data(){
        return{
            dataLogin : {
                email: null,
                password: null
            },
            message : false
        }
    },
    methods: {
        login(){
            let data = this.dataLogin;
            userService.login(data).then(response => {
                console.log(response);
                this.$router.push("/home"); 
            }).catch(e => {
                console.log(e);
                this.message = true;
            })

        }
    }
}
</script>

<style scoped>
  .divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
.h-custom {
height: calc(100% - 73px);
}
@media (max-width: 450px) {
.h-custom {
height: 100%;
}
}
.btn {
    width: 370px;
    margin: 0;
}
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
.section {
    height: 800px;
}
.card{
    width: 63vh;
}
.form-control{
    width: 370px;
}
</style>