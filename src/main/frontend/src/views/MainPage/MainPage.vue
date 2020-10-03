<template>
<div>
    <br>
    <most-popular-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)"></most-popular-surveys>
    <br>
    <latest-surveys class="surveyCreatorComponent" @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)"></latest-surveys>
</div>
</template>

<script>
import MostPopularSurveys from './MostPopularSurveys';
import LatestSurveys from "./LatestSurveys"

export default {
    components: {
        MostPopularSurveys,
        LatestSurveys
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
