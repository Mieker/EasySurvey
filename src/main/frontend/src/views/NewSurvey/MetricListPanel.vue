<template>
<div id="metricList" v-if="this.questions.length > 0">
    <ul v-for="question in this.questions" v-bind:key="question">
        {{ questions.indexOf(question)+1 }}. {{ question.questionText }} <button class="button-small" style="margin: 0 30px">X</button>
        <li v-for="answer in question.answers" v-bind:key="answer">
            - {{ answer }}
        </li>
    </ul>
</div>
</template>

<script>

export default {
    props: ['questions']

}
</script>

<style>
#metricList {
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
    margin: 0 20px;
    font-weight: normal;
    font-style: italic;
}

.button-small {
  font-size: 1rem;
  height: 2.8rem;
  line-height: 2.8rem;
  padding: 0 1.5rem;
  background-color: coral;
}

</style>
