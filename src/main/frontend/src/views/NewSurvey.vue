<template>
<div id="new_survey">
    <DescriptionPanel @getSurveyDescription="getSurveyDescriptionFromChild($event)"/>
    <p></p>
    <CreateMetric @getMetricQuestions="getMetricQuestionsFromChild($event)" />
    <p></p>
    <CreateSurvey @getSurveyQuestions="getSurveyQuestionsFromChild($event)"/>
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
        },
        createSurvey() {
            alert('stworzono ankiete');
            this.$http.post('survey', this.survey)
                .then(response => {
                    alert('ok');

                })
                .catch(response => {
                    alert('nie ok');
                });
        }
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
