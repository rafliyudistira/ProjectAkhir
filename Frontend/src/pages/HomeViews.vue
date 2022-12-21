<template>
    <div class="d-flex">
        <SideBarComponents></SideBarComponents>
        <div class="bar">
        <NavbarComponents></NavbarComponents>
        <BoxComponents></BoxComponents>
        <TableComponents></TableComponents>
        </div>
    </div>
</template>

<script>
import SideBarComponents from "../components/SideBarComponents.vue"
import NavbarComponents from "../components/NabvarComponents.vue"
import BoxComponents from "../components/BoxComponents"
import TableComponents from "../components/TableComponents.vue"

export default {
    name : "HomeViews",
    components : {
        SideBarComponents,
        NavbarComponents,
        BoxComponents,
        TableComponents,
    }

}
</script>

<style>
.bar {
    margin-left: 250px;
}
</style>