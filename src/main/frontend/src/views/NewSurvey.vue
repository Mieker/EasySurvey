<template>
<div id="new_survey">
    <br>
    <DescriptionPanel @getSurveyDescription="getSurveyDescriptionFromChild($event)" />
    <br>
    <CreateMetric @getMetricQuestions="getMetricQuestionsFromChild($event)" @failure="failure($event)" />
    <br>
    <CreateSurvey @getSurveyQuestions="getSurveyQuestionsFromChild($event)" @failure="failure($event)" />
    <br>
    <vue-recaptcha sitekey="6LcsB9YZAAAAAP8R-Xq0Ff0BkZv2LKfz6cS2OhZv"></vue-recaptcha>
    <button class="button-yellow" id="createSurveyButton" @click="submitSurvey">Create the survey</button>
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
        DescriptionPanel,
        'vue-recaptcha': VueRecaptcha,
    },
    props: ['surveyID'],
    data() {
        return {
            survey: {
                title: '',
                description: '',
                questions: [],
                metrics: []
            }
        }
    },
    methods: {
        getSurveyDescriptionFromChild(description) {
            this.survey.title = description.title;
            this.survey.description = description.description;
        },
        getMetricQuestionsFromChild(questions) {
            this.survey.metrics = questions;
        },
        getSurveyQuestionsFromChild(questions) {
            this.survey.questions = questions;
        },
        callForSurveyElements() {
            dataBus.$emit('callForSurveyElements');

            var isSurveyComplet = true;
            if (this.survey.title.trim() === '' || this.survey.description.trim() === '') {
                isSurveyComplet = false;
            }
            if (this.survey.questions.length <= 0) {
                isSurveyComplet = false;
            }
            if (this.survey.metrics.length <= 0) {
                isSurveyComplet = false;
            }

            if (isSurveyComplet) {
                this.createSurvey();
            } else {
                this.failure('To create new survey you need to fulfill all the inputs!')
            }
        },
        createSurvey() {
            this.warning("creating the survey...")
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
        warning(message) {
            this.$emit("warning", message);
        },
        submitSurvey() {
            //TODO
            alert('submitSurvey() runs');
            this.verifyRecaptcha();
            this.callForSurveyElements();
        },
        verifyRecaptcha() {
            //TODO
            var recaptchaToken = grecaptcha.getResponse();
            // alert('verifyRecaptcha() runs: ' + recaptchaToken);
            this.$http.post('recaptcha/' + recaptchaToken)
                .then(response => {
                   alert(response.body);
                   
                })
                .catch(response => {
                   
                   
                });

        }
    }
};
</script>

<style>

</style>
