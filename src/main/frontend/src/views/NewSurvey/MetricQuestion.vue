<template>
<div class="surveyCreatorComponent">
    <p>METRIC QUESTION:</p>
    <input class="inputQuestionBar" type="text" v-model="inputedQuestion">
    <p>OFFERED ANSWERS:</p>
    <ul>
        <li v-for="answer in this.answers" v-bind:key="answer">- {{ answer }}</li>
    </ul>
    <input class="inputAnswerBar" type="text" v-model="inputedAnswer">
    <button class="button-blue" @click="addAnswer">ADD METRIC ANSWER</button>
</div>
</template>

<script>
import { dataBus } from '../../main';

export default {
    data() {
        return {
            answers: [],
            inputedAnswer: '',
            inputedQuestion: ''
        }
    },
    methods: {
        addAnswer() {
            this.answers.push(this.inputedAnswer);
            this.inputedAnswer = '';
        },
        pushQuestionToParentComponent() {
            this.$emit('question', this.inputedQuestion, this.answers);
            this.answers = [];
            this.inputedQuestion = '';
        }
    },
    created() {
        dataBus.$on('pullMetricQuestion', this.pushQuestionToParentComponent);
    }
}
</script>

<style scoped>
ul {
    list-style: none;
    text-align: left;
    margin: 0 5% 0 5%;
}

li {
    margin: 0;
}

p {
    margin: 0;
}

.inputAnswerBar {
    width: 60%;
}

.inputQuestionBar {
    width: 95%;
}

</style>
