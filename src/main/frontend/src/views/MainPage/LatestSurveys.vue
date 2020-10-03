<template>
<div>
    <p class="mainNames">Latest surveys</p>
    <ul>
        <li class="listContainer" v-for="survey in latestSurveys" v-bind:key="survey" @click="sendSurveyIdToSurveyPage(survey[1])">
          <span>{{ survey[0] }}</span><span>ID: {{ survey[1] }}</span>
        </li>
    </ul>
</div>
</template>

<script>
export default {
    data() {
        return {
            latestSurveys: []
        }
    },
    mounted() {
        this.loadLatestSurveys();
    },
    methods: {
        loadLatestSurveys() {
            this.$http.get('survey/latest').then(response => {
                this.latestSurveys = response.body;
            }, response => {
                // error callback
            });
        },
        sendSurveyIdToSurveyPage(IdOfSurvey) {
            this.$emit('sendSurveyIdToSurveyPage', IdOfSurvey);
        }
    }

}
</script>

<style>

</style>
