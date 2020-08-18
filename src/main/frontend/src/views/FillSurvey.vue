<template>
  <div id="fill_survey">
    <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">
    <transition
      name="custom-classes-transition"
      enter-active-class="animated bounceInRight"
      leave-active-class="animated bounceOutRight"
    >
      <div>
        <br>
        <h3>{{survey.description}}</h3>
        <div v-for="question in survey.questions" :key="question.id">
          <fill-survey-question v-bind:question="question" @error="failure($event)" @success="success($event)" @selected="answerSelected($event)"></fill-survey-question>
        </div>
        <button v-if="!submitted" class = "button-blue" @click="submitAnswer()"  >submit your survey</button>  
      </div>
    </transition>
  </div>
</template>

<script>
    import FillSurveyQuestion from "./FillSurveyQuestion";
    export default {
      components: {FillSurveyQuestion},
      props: ["surveyId"],
      
      data() {
          return {
              survey: "",
              answers: [],
              submitted: false,
          }
      },

      watch: { 
        surveyId: function() {
          this.loadSurvey();
        }
      },

      methods: {
        loadSurvey() {
          this.$http.get('survey/' + this.surveyId)
          .then( response => {
            this.survey = response.body;
            this.answers = [];
            this.submitted = false;
            this.success("Successfuly loaded survey ID" + this.survey.id + " with " + this.survey.questions.length + " questions");

          })
          .catch( response => {
            this.failure('Error ' + response.status + ' while loading the survey.');
          })
        },

        answerSelected(answer) {
          var found = false;
          for (var recordedAnswer of this.answers) {
            if (recordedAnswer.questionId == answer.questionId) {
              found = true;
              recordedAnswer.answerId = answer.answerId;
            }
          }
          if (!found) {
            this.answers.push(answer);
          }
        },

        submitAnswer(){
          var complete = true;
          for (var question of this.survey.questions){
            var found = false;
            for (var answer of this.answers) {
              if (answer.questionId == question.id){
                found = true;
              }
            }
            if (!found){
              complete = false;
            }
          }
          if (!complete){
            this.failure("please answer all questions");
          } else {
            this.success("your answers were succesfully submitted");
            this.submitted = true;
          }
        },

        success(message) {
          this.$emit("success", message);
        },

        failure(message) {
          this.$emit("error", message);
        },

      },
      
      mounted(){
        this.loadSurvey();
      },

    };
</script>

