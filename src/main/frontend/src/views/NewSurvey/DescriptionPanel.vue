<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">DESCRIPTION PANEL</p>
    <textarea name="" id="" cols="30" rows="10" v-model="description"></textarea>
</div>
</template>

<script>
export default {
    data() {
        return {
            description: ''
        }
    }

}
</script>

<style>
textarea {
    width: 95%;
}
</style>
