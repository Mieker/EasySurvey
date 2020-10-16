<template>
<div>
    <p class="mainNames">Find survey</p>
    <div style="display: flex; justify-content: center">
        <input class="findSurveyBar" type="text" v-model="searchWord">
        <button class="button-blue" @click="searchForSurvey">SEARCH</button>
    </div>
    <ul>
        <li class="listContainer" v-for="survey in searchingResults" v-bind:key="survey">
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
            searchWord: '',
            searchingResults: [],
        }
    },
    methods: {
        searchForSurvey() {
            var urlValue = 'survey/find/' + this.searchWord;

            this.$http.get(urlValue).then(response => {
                this.searchingResults = response.body;
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

<style scoped>
    .findSurveyBar {
        width: 70%;
        margin-right: 10px;
    }

    .listContainer {
        display: flex;
    }

    .listContainer:hover {
        background-color: #F5A528;
        color: #203C4A;
    }

    .innerListContainer {
        width: 100%;
        display: flex;
        justify-content: space-between;
        padding-left: 10px;
        padding-right: 10px;
    }

</style>
