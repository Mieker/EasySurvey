<template>
<div>
    <p class="mainNames">Latest surveys</p>
    <ul>
        <li class="listContainer" v-for="survey in latestSurveys" v-bind:key="survey">
            <div class="innerListContainer" @click="sendSurveyIdToSurveyPage(survey[1])">
                <span>{{ survey[0] }}</span>
                <span class="idSpan">ID: {{ survey[1] }}</span>
            </div>
            <div class="fasDiv">
                <font-awesome-icon icon="chart-bar" class="fa-lg" @click="goToStatistics(survey[1])" />
            </div>
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
        },
        goToStatistics(IdOfSurvey) {
            this.$emit('goToStatistics', IdOfSurvey);
        }
    }

}
</script>

<style>

</style>
