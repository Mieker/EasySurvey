<template>
<div>
    <p class="mainNames">Most popular surveys</p>
    <ul>
        <li class="listContainer" v-for="survey in mostPopularSurveys" v-bind:key="survey" @click="sendSurveyIdToSurveyPage(survey[1])">
            <span>{{ survey[0] }}</span><span>ID: {{ survey[1] }}</span>
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
        }
    }

}
</script>

<style>

</style>
