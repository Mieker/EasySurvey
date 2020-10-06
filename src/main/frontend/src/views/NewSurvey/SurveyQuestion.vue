<template>
<div>
    <p>Question:</p>
    <input class="inputQuestionBar" type="text" v-model="questionText">
    <p>Offered answer:</p>
    <ul>
        <li v-for="answer in this.potentialQuestionAnswers" v-bind:key="answer">
            <button class="button-small" style="margin: 0 10px" @click="potentialQuestionAnswers.splice(potentialQuestionAnswers.indexOf(answer), 1)">X</button>
            - {{ answer.text }}
        </li>
    </ul>
    <input class="inputAnswerBar" type="text" v-model="text">
    <button class="button-blue" @click="addAnswer">ADD ANSWER</button>
</div>
</template>

<script>
import {
    dataBus
} from '../../main';

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
            if (this.text === '') {
                this.failure('You cannot input an empty answer!');
            } else {
                this.potentialQuestionAnswers.push({
                    text: this.text
                });
                this.text = '';
            }
        },
        pushQuestionToParentComponent() {
            if (this.questionText === '' || this.potentialQuestionAnswers.length <= 0) {
                this.failure("This question doesn't have all the required elements!");
            } else {
                this.$emit('question', this.questionText, this.potentialQuestionAnswers);
                this.potentialQuestionAnswers = [];
                this.questionText = '';
            }
        },
        failure(message) {
            this.$emit('failure', message);
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
