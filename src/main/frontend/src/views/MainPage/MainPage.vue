<template>
<div>
    <find-survey class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)" @goToStatistics="goToStatistics($event)"></find-survey>
    <br>
    <most-popular-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)" @goToStatistics="goToStatistics($event)"></most-popular-surveys>
    <br>
    <latest-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)" @goToStatistics="goToStatistics($event)"></latest-surveys>
</div>
</template>

<script>
import MostPopularSurveys from './MostPopularSurveys';
import LatestSurveys from "./LatestSurveys";
import FindSurvey from "./FindSurvey";

export default {
    components: {
        MostPopularSurveys,
        LatestSurveys,
        FindSurvey
    },
    data() {
        return {
            mostPopularSurveys: [],
            latestSurveys: []
        }
    },
    methods: {
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
