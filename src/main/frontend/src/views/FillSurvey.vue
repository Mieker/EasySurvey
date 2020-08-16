<template>
  <div v-if="survey" id="fill_survey">
    <h4> {{survey.description}}</h4>
    <div v-for="question in survey.questions" :key="question.id">
      {{question.id}}.{{question.questionText}}
      <p v-for="potentialanswer in question.potentialQuestionAnswers" :key="potentialanswer.id">{{potentialanswer.text}}</p>
    </div>
  </div>
</template>

<script>
    export default {
      props: ["surveyId"],
      
      data() {
          return {
              survey: "",
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
            this.success("Successfuly loaded survey ID" + this.survey.id + " with " + this.survey.questions.length + " questions");

          })
          .catch( response => {
            this.failure('Error ' + response.status + ' while loading the survey.');
          })
        },

        // loadQuestions(){
        //   this.$http.get('survey/' + this.surveyId + 'questions')
        //   .then( response => {
        //     this.survey.questions = response.body;
        //     this.success("successfuly loaded survey ID" + this.survey.id + " with " + this.survey.questions.length + " questions");

        //   })
        //   .catch( response => {
        //     this.failure('Error ' + response.status + ' while loading questions to the survey.');
        //   })
        // },

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