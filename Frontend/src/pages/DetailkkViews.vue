<template>
    <div class="d-flex">
        <SideBarComponents></SideBarComponents>
        <div class="bar">
        <NavbarComponents></NavbarComponents>
        <div>
            <AddkkComponents></AddkkComponents>
            <TableComponents v-show="none" @updateKartu="kakaUpdate"></TableComponents>                                                                         
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
import NavbarComponents from "../components/NabvarComponents.vue"
import AddkkComponents from '../components/AddkkComponents.vue'
import TableComponents from '../components/TableComponents.vue'
// import DetailkkComponents from "../components/DetailkkComponents.vue"
// import UpdatekkComponents from "../components/UpdatekkComponents.vue"
// import DaftarkkComponents from "../components/DaftarkkComponents.vue"
// import AddakComponents from "../components/AddakComponents.vue"
// import DetailakComponents from "../components/DetailakComponents.vue"
// import UpdateakComponents from "../components/UpdateakComponents.vue"

export default {
    name : "DetailkkViews",
    components : {
        SideBarComponents,
        NavbarComponents,
        TableComponents,
        AddkkComponents
        // DetailkkComponents,
        // UpdatekkComponents,
        // DaftarkkComponents,
        // AddakComponents,
        // DetailakComponents,
        // UpdateakComponents,
    },
    data(){
        return{
            kakaData : null,
            none: false
        }
    },
    methods:{
        kakaUpdate(item){
            this.kakaData = item
        }
    }

}
</script>

<style>
.bar {
    margin-left: 250px;
}
</style>