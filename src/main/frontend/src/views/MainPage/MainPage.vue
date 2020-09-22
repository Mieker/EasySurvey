<template>
<div>
    <most-popular-surveys class="surveyCreatorComponent"></most-popular-surveys>
    <latest-surveys class="surveyCreatorComponent"></latest-surveys>
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
    }

}
</script>

<style>

</style>
