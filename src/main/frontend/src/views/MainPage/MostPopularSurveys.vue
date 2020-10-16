<template>
<div>
    <p class="mainNames">Most popular surveys</p>
    <ul>
        <li class="listContainer" v-for="survey in mostPopularSurveys" v-bind:key="survey">
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
            mostPopularSurveys: []
        }
    },
    mounted() {
        this.loadMostPopularSurveys();
    },
    methods: {
        loadMostPopularSurveys() {
            this.$http.get('survey/most_popular').then(response => {
                this.mostPopularSurveys = response.body;
            }, response => {
                //error
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