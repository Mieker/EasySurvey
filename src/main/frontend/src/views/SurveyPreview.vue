<template>
  <div id="survey_preview">
    <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">
    <transition
      name="custom-classes-transition"
      enter-active-class="animated bounceInRight"
      leave-active-class="animated bounceOutRight"
    >
      <div>
        <br>
        <h4>The survey title: <b>{{survey.title}}</b></h4>
        <div class="surveyCreatorComponent" style="padding: 10px">
            <p>{{ survey.description }}</p>
        </div>

        <br>

        <div id="metrics" class="surveyCreatorComponent">
          <p class="mainNames">Metrics</p>
          <div v-for="metricQuestion in survey.metrics" :key="metricQuestion.id">
            <fill-survey-metric-question v-bind:metricQuestion="metricQuestion" @error="failure($event)" @success="success($event)" @selected="metricAnswerSelected($event)"></fill-survey-metric-question>
          </div>
        </div>

        <br>
        
        <div id="questions" class="surveyCreatorComponent">
          <p class="mainNames">Questions</p>
          <div v-for="question in survey.questions" :key="question.id">
            <fill-survey-question v-bind:question="question" @error="failure($event)" @success="success($event)" @selected="answerSelected($event)"></fill-survey-question>
          </div>
        </div>

      </div>
    </transition>
  </div>
</template>

<script>
    import FillSurveyQuestion from "./FillSurveyQuestion";
    import FillSurveyMetricQuestion from "./FillSurveyMetricQuestion";
    
    export default {
      components: {
          FillSurveyQuestion,
          FillSurveyMetricQuestion,
      },
      props: ["survey"],
      
      data() {
          return {
              answers: [],
              metricAnswers: [],
              submitted: false,
              postText: "",
              answeredSurvey: {
                questionIds: [],
                answerIds: [],
                metricIds: [],
                metricAnswersIds: []
              }
          }
	  }
	}
 
</script>