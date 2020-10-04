<template>
<div>
    <p class="mainNames">Find survey</p>
    <div style="display: flex; justify-content: center">
        <input class="findSurveyBar" type="text" v-model="searchWord">
        <button class="button-blue" @click="searchForSurvey">SEARCH</button>
    </div>
    <ul>
        <!-- <li class="listContainer" v-for="survey in mostPopularSurveys" v-bind:key="survey" @click="sendSurveyIdToSurveyPage(survey[1])">
            <span>{{ survey[0] }}</span><span>ID: {{ survey[1] }}</span>
        </li> -->
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

        }
    }

}
</script>

<style scoped>
.findSurveyBar {
    width: 70%;
    margin-right: 10px;
}
</style>
