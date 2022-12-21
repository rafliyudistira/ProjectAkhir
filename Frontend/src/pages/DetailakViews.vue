<template>
    <div class="d-flex">
        <SideBarComponents></SideBarComponents>
        <div class="bar">
        <!-- <NavbarComponents></NavbarComponents> -->
        <div>
            <AddakComponents :propsAnggota="anggotaData"></AddakComponents>
            <ListakComponents v-show="none" @updateAnggota="anggotaUpdate"></ListakComponents>
            <!-- <TableComponents v-show="none" @updateKartu="kakaUpdate"></TableComponents>                                                                          -->
        </div>
        <!-- <DetailkkComponents></DetailkkComponents> -->
        <!-- <UpdatekkComponents></UpdatekkComponents> -->
        <!-- <DaftarkkComponents></DaftarkkComponents> -->
        <!-- <AddakComponents></AddakComponents> -->
        <!-- <DetailakComponents></DetailakComponents> -->
        <!-- <UpdateakComponents></UpdateakComponents> -->
        </div>
    </div>
</template>

<script>
import SideBarComponents from "../components/SideBarComponents.vue"
// import NavbarComponents from "../components/NabvarComponents.vue"
// import AddkkComponents from '../components/AddkkComponents.vue'
import TableComponents from '../components/TableComponents.vue'
import AddakComponents from "../components/AddakComponents.vue"
import ListakComponents from "../components/ListakComponents.vue"
// import DetailkkComponents from "../components/DetailkkComponents.vue"
// import UpdatekkComponents from "../components/UpdatekkComponents.vue"
// import DaftarkkComponents from "../components/DaftarkkComponents.vue"
// import AddakComponents from "../components/AddakComponents.vue"
// import DetailakComponents from "../components/DetailakComponents.vue"
// import UpdateakComponents from "../components/UpdateakComponents.vue"

export default {
    name : "DetailakViews",
    components : {
        SideBarComponents,
        // NavbarComponents,
        AddakComponents,
        TableComponents,
        ListakComponents,
        // AddkkComponents
        // DetailkkComponents,
        // UpdatekkComponents,
        // DaftarkkComponents,
        // AddakComponents,
        // DetailakComponents,
        // UpdateakComponents,
    },
    data(){
        return{
            anggotaData : null,
        }
    },
    methods:{
        anggotaUpdate(item){
            this.anggotaData = item
        }
    }

}
</script>

<style>
.bar {
    margin-left: 250px;
}
.navbar {
    width: 160vh;
    border-radius: 20px;
    margin-top: 20px;
    height: 70px;
    margin-left: 20px;
}
</style>