<template>
<div>
    <find-survey class="surveyCreatorComponent"></find-survey>
    <br>
    <most-popular-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)"></most-popular-surveys>
    <br>
    <latest-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)"></latest-surveys>
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
        }
    }

}
</script>

<style>

</style>
