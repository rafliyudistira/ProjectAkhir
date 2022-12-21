<template>
    <div class="d-flex">
        <SideBarComponents></SideBarComponents>
        <div class="bar">
        <NavbarComponents></NavbarComponents>
        <AddakComponents></AddakComponents>
        </div>
    </div>
</template>

<script>
import SideBarComponents from "../components/SideBarComponents.vue"
import NavbarComponents from "../components/NabvarComponents.vue"
import AddakComponents from "../components/AddakComponents.vue"

export default {
    name : "HomeViews",
    components : {
        SideBarComponents,
        NavbarComponents,
        AddakComponents,
    }

}
</script>

<style>
.bar {
    margin-left: 250px;
}
</style>