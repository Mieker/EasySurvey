<template>
    <div class="surveyCreatorComponent">
        <p class="mainNames">Questions creator panel</p>
        <app-Questions-List-Panel :questions="questions"></app-Questions-List-Panel>
        <SurveyQuestion v-on:question="addQuestion" @failure="failure($event)"></SurveyQuestion>
        <button class="button-blue" @click="pullQuestion">ADD QUESTION</button>
    </div>
</template>

<script>
import SurveyQuestion from './SurveyQuestion';
import QuestionsListPanel from '../NewSurvey/QuestionsListPanel';
import {
    dataBus
} from '../../main';

export default {
    components: {
        SurveyQuestion,
        appQuestionsListPanel: QuestionsListPanel,
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
            dataBus.$emit('pullQuestion');
        },
        addQuestion(inputedQuestion, answers) {
            this.questions.push({
                questionText: inputedQuestion,
                potentialQuestionAnswers: answers
            });
        },
        pushQuestionsToParentComponent() {
            this.$emit('getSurveyQuestions', this.questions);
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
