<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">QUESTIONS CREATOR PANEL</p>
    <app-Questions-List-Panel :questions="questions"></app-Questions-List-Panel>
    <SurveyQuestion v-on:question="addQuestion"></SurveyQuestion>
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
        }
    },
    created() {
        dataBus.$on('callForSurveyElements', this.pushQuestionsToParentComponent);
    }
}
</script>

<style>

</style>
