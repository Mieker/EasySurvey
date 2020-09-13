<template>
  <div class="surveyCreatorComponent">
      <p>QUESTION:</p>
      <input class="inputQuestionBar" type="text" v-model="questionText">
    <p>OFFERED ANSWERS:</p>
    <ul>
        <li v-for="answer in this.potentialQuestionAnswers" v-bind:key="answer">- {{ answer.text }}</li>
    </ul>
    <input class="inputAnswerBar" type="text" v-model="text">
    <button class="button-blue" @click="addAnswer">ADD ANSWER</button>
</div>
</template>

<script>
import { dataBus } from '../../main';

export default {
    data() {
        return {
            potentialQuestionAnswers: [],
            text: '',
            questionText: ''
        }
    },
    methods: {
        addAnswer() {
            this.potentialQuestionAnswers.push({
                text: this.text
            });
            this.text = '';
        },
        pushQuestionToParentComponent() {
            this.$emit('question', this.questionText, this.potentialQuestionAnswers);
            this.potentialQuestionAnswers = [];
            this.questionText = '';
        }
    },
    created() {
        dataBus.$on('pullQuestion', this.pushQuestionToParentComponent);
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
