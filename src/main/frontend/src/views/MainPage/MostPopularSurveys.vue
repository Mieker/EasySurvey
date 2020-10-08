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
                <font-awesome-icon icon="chart-bar" class="fa-lg" @click="goToStatistics" />
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
        goToStatistics() {
            alert('uruchomiono alarm');
        }
    }

}
</script>

<style>
font-awesome-icon {
    color: #135A7A;
}

.fasDiv {
    margin-right: 10px;
}

.fasDiv:hover {
    color: white;
}

.innerListContainer {
    width: 100%;
    display: flex;
    justify-content: space-between;
    padding-left: 10px;
    padding-right: 10px;
}

.idSpan {
    width: 100px;
    margin-right: 50px;
    text-align: left;
}
</style>
