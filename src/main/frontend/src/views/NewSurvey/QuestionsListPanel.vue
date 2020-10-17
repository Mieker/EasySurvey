<template>
<div id="questionsList" v-if="this.questions.length > 0">
    <ul v-for="question in this.questions" v-bind:key="question">
        <button class="button-small" style="margin: 0 10px" @click="questions.splice(questions.indexOf(question), 1)">X</button> {{ questions.indexOf(question)+1 }}. {{ question.questionText }} 
        <li v-for="answer in question.potentialQuestionAnswers" v-bind:key="answer">
            - {{ answer.text }}
        </li>
    </ul>
</div>
</template>

<script>

export default {
    props: ['questions']

}
</script>

<style scoped>
#questionsList {
    text-align: left;
}

ul {
    list-style: none;
    text-align: left;
    margin: 0 15% 0 15%;
    font-weight: bold;
    color: cornflowerblue;
}

li {
    margin: 0 80px;
    font-weight: normal;
    font-style: italic;
}

</style>
