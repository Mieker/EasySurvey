<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">Description panel</p>
    <p>Survey title:</p>
    <input class="inputQuestionBar" type="text" v-model="descriptionPanel.title">
    <p>Survey description:</p>
    <textarea name="" id="" cols="30" rows="10" v-model="descriptionPanel.description"></textarea>
</div>
</template>

<script>
import {
    dataBus
} from '../../main';

export default {
    data() {
        return {
            descriptionPanel: {
                title: '',
                description: ''
            }
        }
    },

    watch: { 
        'descriptionPanel.title': function() {
          this.pushDescriptionToParentComponent();
        },
        'descriptionPanel.description': function() {
          this.pushDescriptionToParentComponent();
        }
      },
    
    methods: {
        pushDescriptionToParentComponent() {
            this.$emit('getSurveyDescription', this.descriptionPanel);
        }
    },
    created() {
        dataBus.$on('callForSurveyElements', this.pushDescriptionToParentComponent);
    }

}
</script>

<style scoped>
textarea {
    width: 95%;
}

.inputQuestionBar {
    width: 95%;
}

p {
    margin: 0;
}
</style>
