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
        <h4>The survey description: <b>{{survey.description}}</b></h4>
        
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

        <br>
        <button v-if="!submitted" class = "button-yellow" @click="submitAnswer()"  >submit your survey</button>  
      
      </div>
    </transition>
  </div>
</template>

<script>
    import FillSurveyQuestion from "./FillSurveyQuestion";
    import FillSurveyMetricQuestion from "./FillSurveyMetricQuestion";
    
    export default {
      components: {FillSurveyQuestion, FillSurveyMetricQuestion},
      props: ["surveyId"],
      
      data() {
          return {
              survey: "",
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
      },

      watch: { 
        surveyId: function() {
          this.loadSurvey();
        }
      },

      methods: {
        loadSurvey() {
          this.warning("loading a survey...");
          this.$http.get('survey/' + this.surveyId)
          .then( response => {
            this.survey = response.body;
            this.answers = [];
            this.metricAnswers = [];
            this.answeredSurvey.questionIds = [];
            this.answeredSurvey.answerIds = [];
            this.answeredSurvey.metricIds = [];
            this.answeredSurvey.metricAnswersIds = [];
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

        metricAnswerSelected(metricAnswer) {
          var found = false;
          for (var recordedMetricAnswer of this.metricAnswers) {
            if (recordedMetricAnswer.metricQuestionId == metricAnswer.metricQuestionId) {
              found = true;
              recordedMetricAnswer.metricAnswerId = metricAnswer.metricAnswerId;
            }
          }
          if (!found) {
            this.metricAnswers.push(metricAnswer);
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

          if (complete) {
            for (var metricQuestion of this.survey.metrics){
              var found = false;
              for (var metricAnswer of this.metricAnswers) {
                if (metricAnswer.metricQuestionId == metricQuestion.id){
                  found = true;
                }
              }
              if (!found){
                complete = false;
              }
            }
          }

          if (!complete){
            this.failure("please answer all questions");
          } 
          else {

            for (var answer of this.answers) {
              this.answeredSurvey.questionIds.push(answer.questionId); 
              this.answeredSurvey.answerIds.push(answer.answerId);
            };

            for (var metricAnswer of this.metricAnswers) {
              this.answeredSurvey.metricIds.push(metricAnswer.metricQuestionId); 
              this.answeredSurvey.metricAnswersIds.push(metricAnswer.metricAnswerId);
            };
            
            var postText = "question/" + this.survey.id;
            this.$emit("warning","storing your answers...")
            this.$http.post(postText, this.answeredSurvey)
                .then(response => {
                    this.surveyID = response.body.id;
                    this.$emit("success","Your answers were succesfully submitted.");
                    this.submitted = true;
                    //this.sleep(3000);
                    this.$emit("setView", "statistics");
                })
                .catch(response => {
                    this.failure("Something went wrong. Your answers couldn't be submitted. Error " + response.status);
                });
          }
        },

        sleep(milliseconds) {
          const date = Date.now();
          let currentDate = null;
          do {
            currentDate = Date.now();
          } while (currentDate - date < milliseconds);
        },

        success(message) {
          this.$emit("success", message);
        },

        failure(message) {
          this.$emit("error", message);
        },
        warning(message) {
          this.$emit("warning", message);
        }

      },
      
      mounted(){
        this.loadSurvey();
      },

    };
</script>

