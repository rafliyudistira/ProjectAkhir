<template>
    <div>
      <div class="wrapper p-3">
        <!-- Sidebar  -->
        <nav id="sidebar" class="sidebar border-left-warning shadow p-3" style="border-radius: 25px;">
            <div class="sidebar-header gradient-custom-3" style="border-radius: 25px;">
                <h3>E-KTP APP</h3>
            </div>

            <ul class="list-unstyled components">
                <li class="active">
                    <router-link to="/home" data-toggle="collapse" aria-expanded="false" class=""><img class="bi bi-house-heart" src="../assets/img/home.png">Home</router-link>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                    </ul>
                </li>
                <li>
                    <router-link to="/Addkk"><img class="bi bi-house-heart" src="../assets/img/plus.png">Tambah KK</router-link>
                </li>
                 <!-- <li>
                    <router-link to="/Detailkk"><img class="bi bi-house-heart" src="../assets/img/detail.png">Detail KK</router-link>
                </li> -->
                <li>
                    <router-link to="/" data-toggle="collapse" aria-expanded="false" class=""><img class="bi bi-house-heart" src="../assets/img/exit.png">Sign Out</router-link>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                    </ul>
                </li>
            </ul>
        </nav>


    </div>
    </div>
</template>

<script>
export default {
        name : "SideBarComponents"
}
</script>

<style scoped>
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
.gradient-custom-4 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}

@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";
body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: rgb(136, 136, 136);
}

a,
a:hover,
a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

.navbar {
    padding: 15px 10px;
    background: #fff;
    border: none;
    border-radius: 0;
    margin-bottom: 40px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);

}

.navbar-btn {
    box-shadow: none;
    outline: none !important;
    border: none;
}

.line {
    width: 100%;
    height: 1px;
    border-bottom: 1px dashed #ddd;
    margin: 40px 0;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */

.wrapper {
    display: flex;
    width: 100%;
    align-items: stretch;
}

#sidebar {
    min-width: 250px;
    max-width: 250px;
  
    color: rgb(120, 120, 120);
    transition: all 0.3s;
}

#sidebar.active {
    margin-left: -250px;
}

#sidebar .sidebar-header {
    padding: 20px;
   
}

#sidebar ul.components {
    padding: 20px 0;
   
}

#sidebar ul p {
    color: rgb(120, 120, 120);
    padding: 10px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}

#sidebar ul li a:hover {
    border-radius: 30px;
    color: #7386D5;
    background: rgb(237, 237, 237);
}

#sidebar ul li.active>a,
a[aria-expanded="true"] {
    color: rgb(120, 120, 120);
    
}

a[data-toggle="collapse"] {
    position: relative;
}

.dropdown-toggle::after {
    display: block;
    position: absolute;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
}

ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #6d7fcc;
}

ul.CTAs {
    padding: 20px;
}

ul.CTAs a {
    text-align: center;
    font-size: 0.9em !important;
    display: block;
    border-radius: 5px;
    margin-bottom: 5px;
}

a.download {
    background: #fff;
    color: #7386D5;
}

a.article,
a.article:hover {
    background: #6d7fcc !important;
    color: #fff !important;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */

#content {
    width: 100%;
    padding: 20px;
    min-height: 100vh;
    transition: all 0.3s;
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */

@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
    }
    #sidebar.active {
        margin-left: 0;
    }
    #sidebarCollapse span {
        display: none;
    }
}
.sidebar {
    height: 757px;
    position: fixed;
    z-index: 1;
    overflow: hidden;
}
.backgroundcol {
    background-color: rgb(255, 255, 255);
}
.bi {
    height: 40px;
    margin-right: 10px;
    margin-bottom: 10px;
}

</style>