<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">Metric creator panel</p>
    <app-Metric-List-Panel :questions="questions"></app-Metric-List-Panel>
    <MetricQuestion v-on:question="addQuestion" @failure="failure($event)"></MetricQuestion>
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

    watch: { 
        'questions': function() {
          this.pushQuestionsToParentComponent();
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
        },
        pushQuestionsToParentComponent() {
            this.$emit('getMetricQuestions', this.questions);
        },
        failure(message) {
            this.$emit('failure', message);
        }
    },
    created() {
        dataBus.$on('callForSurveyElements', this.pushQuestionsToParentComponent);
    }
}
</script>

<style>

</style>
