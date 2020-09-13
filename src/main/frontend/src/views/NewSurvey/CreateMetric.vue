<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">METRIC CREATOR PANEL</p>
    <app-Metric-List-Panel :questions="questions"></app-Metric-List-Panel>
    <MetricQuestion v-on:question="addQuestion"></MetricQuestion>
    <button class="button-blue" @click="pullQuestion">ADD METRIC QUESTION</button>
</div>
</template>

<script>
import MetricQuestion from './MetricQuestion';
import MetricListPanel from '../NewSurvey/MetricListPanel';
import {
    dataBus
} from '../../main';

export default {
    components: {
        MetricQuestion,
        appMetricListPanel: MetricListPanel,
    },
    data() {
        return {
            questions: [],
            
        }
    },
    methods: {
        pullQuestion() {
            dataBus.$emit('pullMetricQuestion');
        },
        addQuestion(inputedQuestion, answers) {
            this.questions.push({
                metricText: inputedQuestion,
                potentialMetricAnswers: answers
            });

            // this.$http.post('metrics', this.testObjMetric)
            //     .then(response => {
            //         alert('ok');
            //         // udało się
            //         // this.newMeeting.id = response.body.id;
            //         // this.$emit('added', this.newMeeting);
            //         // this.newMeeting = {participants: []};
            //         // this.adding = false;
            //     })
            //     .catch(response => {
            //         alert('nie ok');
            //         // nie udało sie     
            //     });
        },
        pushQuestionsToParentComponent() {
            this.$emit('getMetricQuestions', this.questions);
        }
    },
    created() {
        dataBus.$on('callForSurveyElements', this.pushQuestionsToParentComponent);
    }
}
</script>

<style>
.mainNames {
    font-weight: bold;
    color: white;
    background-color: cornflowerblue;
}

</style>
