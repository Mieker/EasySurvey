<template>
<div id="new_survey">
    <DescriptionPanel @getSurveyDescription="getSurveyDescriptionFromChild($event)" />
    <p></p>
    <CreateMetric @getMetricQuestions="getMetricQuestionsFromChild($event)" />
    <p></p>
    <CreateSurvey @getSurveyQuestions="getSurveyQuestionsFromChild($event)" />
    <button class="button-blue" id="createSurveyButton" @click="callForSurveyElements">CREATE EASY SURVEY</button>
</div>
</template>

<script>
import CreateMetric from './NewSurvey/CreateMetric';
import CreateSurvey from './NewSurvey/CreateSurvey';
import DescriptionPanel from './NewSurvey/DescriptionPanel';
import {
    dataBus
} from '../main';

export default {
    components: {
        CreateMetric,
        CreateSurvey,
        DescriptionPanel
    },
    props: ['surveyID'],
    data() {
        return {
            survey: {
                description: '',
                questions: [],
                metrics: []
            }
        }
    },
    methods: {
        getSurveyDescriptionFromChild(description) {
            this.survey.description = description;
        },
        getMetricQuestionsFromChild(questions) {
            this.survey.metrics = questions;
        },
        getSurveyQuestionsFromChild(questions) {
            this.survey.questions = questions;
        },
        callForSurveyElements() {
            dataBus.$emit('callForSurveyElements');
            this.createSurvey();
        },
        createSurvey() {
            this.$http.post('survey', this.survey)
                .then(response => {
                    this.surveyID = response.body.id;
                    this.success("Congratulations! New survey created. You can try it with ID: " + this.surveyID);
                    document.body.scrollTop = document.documentElement.scrollTop = 0;
                })
                .catch(response => {
                    this.failure("Something went wrong. The survey couldn't be created.");
                    document.body.scrollTop = document.documentElement.scrollTop = 0;
                });
        },
        success(message) {
            this.$emit("success", message);
        },

        failure(message) {
            this.$emit("error", message);
        },
    }
};
</script>

<style>
.surveyCreatorComponent {
    border: 1px solid cornflowerblue;
    box-shadow: 2px 2px 5px cornflowerblue;
    margin: 5px;
    padding: 2px;
    text-align: center;
}

.componentFulfillment {
    background-color: deepskyblue;
}

#createSurveyButton {
    float: right;
    margin-right: 5px;
    margin-top: 5px;
    background-color: coral;
}

#createSurveyButton:hover {
    background-color: gray;
}
</style>
