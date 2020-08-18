<template>

  <transition
    name="custom-classes-transition"
    enter-active-class="animated bounceInRight"
    leave-active-class="animated bounceOutRight"
  >
  <div v-if="survey" id="fill_survey">
    <br>
    <h3> {{survey.description}}</h3>
    <div v-for="question in survey.questions" :key="question.id">
      <fill-survey-question v-bind:question="question" @error="failure($event)" @success="success($event)"></fill-survey-question>
    </div>
  </div>
  </transition>
</template>

<script>
    import FillSurveyQuestion from "./FillSurveyQuestion";
    export default {
      components: {FillSurveyQuestion},
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

<style>

	.fade-enter-active, .fade-leave-active {
	transition: opacity .5s;
	}

	.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
	opacity: 0;
	}

</style>