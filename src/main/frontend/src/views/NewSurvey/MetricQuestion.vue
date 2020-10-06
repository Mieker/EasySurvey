<template>
<div>
    <p>Metric question:</p>
    <input class="inputQuestionBar" type="text" v-model="metricText">
    <p>Offered answers:</p>
    <ul>
        <li v-for="answer in this.potentialMetricAnswers" v-bind:key="answer">
            <button class="button-small" style="margin: 0 10px" @click="potentialMetricAnswers.splice(potentialMetricAnswers.indexOf(answer), 1)">X</button>
            - {{ answer.text }}
        </li>
    </ul>
    <input class="inputAnswerBar" type="text" v-model="text">
    <button class="button-blue" @click="addAnswer">ADD METRIC ANSWER</button>
</div>
</template>

<script>
import {
    dataBus
} from '../../main';

export default {
    data() {
        return {
            potentialMetricAnswers: [],
            text: '',
            metricText: ''
        }
    },
    methods: {
        addAnswer() {
            if (this.text === '') {
                this.failure();
            } else {
                this.potentialMetricAnswers.push({
                    text: this.text
                });
                this.text = '';
            }
        },
        pushQuestionToParentComponent() {
            this.$emit('question', this.metricText, this.potentialMetricAnswers);
            this.potentialMetricAnswers = [];
            this.metricText = '';
        },
        failure() {
            this.$emit('failure', 'Cannot input an empty element!');
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

.button-small {
    font-size: 1rem;
    height: 2.8rem;
    line-height: 2.8rem;
    padding: 0 1.5rem;
    background-color: coral;
}

.button-small:hover {
    background-color: gray;
}
</style>
