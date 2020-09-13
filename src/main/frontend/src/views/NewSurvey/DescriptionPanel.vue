<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">DESCRIPTION PANEL</p>
    <textarea name="" id="" cols="30" rows="10" v-model="description"></textarea>
</div>
</template>

<script>
import {
    dataBus
} from '../../main';

export default {
    data() {
        return {
            description: ''
        }
    },
    methods: {
        pushDescriptionToParentComponent() {
            this.$emit('getSurveyDescription', this.description);
        }
    },
    created() {
        dataBus.$on('callForSurveyElements', this.pushDescriptionToParentComponent);
    }

}
</script>

<style>
textarea {
    width: 95%;
}
</style>
