<template>
<div>
    <p>Metric question:</p>
    <input class="inputQuestionBar" type="text" v-model="metricText">
    <p>Offered answers:</p>
    <ul>
        <li v-for="answer in this.potentialMetricAnswers" v-bind:key="answer">- {{ answer.text }}</li>
    </ul>
    <input class="inputAnswerBar" type="text" v-model="text">
    <button class="button-blue" @click="addAnswer">ADD METRIC ANSWER</button>
</div>
</template>

<script>
import { dataBus } from '../../main';

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
            this.potentialMetricAnswers.push({
                text: this.text
            });
            this.text = '';
        },
        pushQuestionToParentComponent() {
            this.$emit('question', this.metricText, this.potentialMetricAnswers);
            this.potentialMetricAnswers = [];
            this.metricText = '';
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
