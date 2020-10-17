<template>
<div id="survey_page">

    <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">

    <transition name="custom-classes-transition" enter-active-class="animated bounceInRight" leave-active-class="animated bounceOutRight">
        <div v-if="mode !=='new_survey'" class="row inputSurveyIdPanel">
            <div class="column column-80">
                <form>
                    <fieldset>
                        <label for="surveyID">Survey ID</label>
                        <input v-model="surveyID" type="text" class="inputText" :placeholder="surveyID" id="surveyID">
                    </fieldset>
                </form>
            </div>
        </div>
    </transition>

    <div class="row mainButtonsPanel">
        <div><button class="button-yellow" v-if="mode!='main_page'" @click="mainPage()">home</button></div>
        <div><button v-bind:class="newSurveyButtonClass" @click="newSurvey()">create a survey</button></div>
        <div><button v-bind:class="fillSurveyButtonClass" @click="fillSurvey()"> fill a survey </button></div>
        <div><button v-bind:class="statisticsButtonClass" @click="statistics()"> see statistics</button></div>
    </div>

    <main-page v-if="mode==='main_page'" 
        @sendSurveyIdToSurveyPage="sendSurveyIdToSurveyPage($event)" 
        @warning="warning($event)"
        @goToStatistics="goToStatistics($event)">
    </main-page>
    
    <new-survey v-if="mode==='new_survey'" :survey-id="surveyID" 
        @error="failure($event)" 
        @success="success($event)" 
        @warning="warning($event)"
        @goToFillSurvey="sendSurveyIdToSurveyPage($event)">
    </new-survey>
    
    <fill-survey v-if="mode==='fill_survey'" :survey-id="surveyID" 
        @error="failure($event)" 
        @success="success($event)" 
        @warning="warning($event)"
        @setView="setView($event)">
    </fill-survey>
    
    <statistics v-if="mode==='statistics'" :survey-id="surveyID" 
        @error="failure($event)" 
        @success="success($event)" 
        @warning="warning($event)">
    </statistics>

</div>
</template>

<script>
import NewSurvey from "./views/NewSurvey";
import FillSurvey from "./views/FillSurvey";
import Statistics from "./views/Statistics";
import MainPage from "./views/MainPage/MainPage"

export default {
    components: {
        NewSurvey,
        FillSurvey,
        Statistics,
        MainPage
    },
    data() {
        return {
            surveys: [],
            surveyID: "",
            newSurveyButtonClass: "button-blue",
            fillSurveyButtonClass: "button-blue",
            statisticsButtonClass: "button-blue",
            mode: "main_page",

        };
    },
    methods: {
        setView(view){
            if (view=="mainPage"){
                this.mainPage();
            } else 
            if (view=="newSurvey"){
                this.newSurvey();
            } else
            if (view=="fillSurvey"){
                this.fillSurvey();
            } else
            if (view=="statistics"){
                this.statistics();
            }
        },

        mainPage() {
            this.success("");
            this.newSurveyButtonClass = "button-blue";
            this.fillSurveyButtonClass = "button-blue";
            this.statisticsButtonClass = "button-blue";
            this.mode = "main_page";
        },
        
        newSurvey() {
            this.success("");
            this.newSurveyButtonClass = "button-blue button-outline";
            this.fillSurveyButtonClass = "button-blue";
            this.statisticsButtonClass = "button-blue";
            this.mode = "new_survey";
        },

        fillSurvey() {
            if (this.surveyID < 1) {
                this.failure("no survey with such ID");
            } else {
                this.success("");
            }
            this.newSurveyButtonClass = "button-blue";
            this.fillSurveyButtonClass = "button-blue button-outline";
            this.statisticsButtonClass = "button-blue";
            this.mode = "fill_survey";
        },

        statistics() {
            if (this.surveyID < 1) {
                this.failure("no survey with such ID");
            } else {
                this.success("");
            }
            this.newSurveyButtonClass = "button-blue";
            this.fillSurveyButtonClass = "button-blue";
            this.statisticsButtonClass = "button-blue button-outline";
            this.mode = "statistics";
        },

        success(message) {
            this.$emit("success", message);
        },

        failure(message) {
            this.$emit("error", message);
        },
        warning(message){
            this.$emit("warning", message);
        },

        sendSurveyIdToSurveyPage(IdOfSurvey) {
            this.surveyID = IdOfSurvey;
            this.fillSurvey();
        },
        goToStatistics(IdOfSurvey) {
            this.surveyID = IdOfSurvey;
            this.statistics();
        }
    }
};
</script>

<style>

</style>
