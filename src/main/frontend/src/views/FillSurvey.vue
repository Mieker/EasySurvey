<template>
  <div id="fill_survey">
    <h3 v-if="survey">{{survey.description}}</h3>
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
            this.success("successfuly loaded survey ID" + this.survey.id);

          })
          .catch( response => {
            this.failure('Błąd podczas pobierania ankiety. Kod błedu: ' + response.status);
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