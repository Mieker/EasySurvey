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
