<template>
<div>
    <SideBarComponents></SideBarComponents>
    <div class="bar1">
        <NavbarComponents></NavbarComponents>
        <ListakComponents class="list1"></ListakComponents>
    </div>
</div>
</template>

<script>
import ListakComponents from "../components/ListakComponents.vue"
import SideBarComponents from "../components/SideBarComponents.vue"
import NavbarComponents from "../components/NabvarComponents.vue"
export default {
    name : "AnggotaViews",
    components : {
        ListakComponents,
        SideBarComponents,
        NavbarComponents,
    }

}
</script>

<style>
.bar1 {
    margin-left: 270px;
}
.nav1 {
    margin-left: 25px;
    width: 147vh;
}
.list1 {
    margin-left: 15px;
    width: 150vh;
}
</style>