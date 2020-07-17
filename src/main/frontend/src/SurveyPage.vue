<template>
  <div>
    <div v-if="mode !=='new_survey'" class="row">
      <div class="column column-80">
        <form>
            <fieldset>
              <label for="surveyID">Survey ID</label>
              <input v-model="surveyID" type="text" :placeholder="surveyID" id="surveyID">
            </fieldset>
        </form>
      </div>
    </div> 
    <div class="row">
      <div class="column"><button v-bind:class = "newSurveyButtonClass" @click="newSurvey()">create a survey</button></div>
      <div class="column"><button v-bind:class = "fillSurveyButtonClass" @click="fillSurvey()">fill a survey</button></div>
      <div class="column"><button v-bind:class = "statisticsButtonClass" @click="statistics()">see statistics</button></div>
    </div>
  </div>
</template>

<script>
    export default {
        data() {
            return {
                surveys: [],
                surveyID: "0",
                newSurveyButtonClass: "button-blue",
                fillSurveyButtonClass: "button-blue",
                statisticsButtonClass: "button-blue",
                mode: "",
            };
        },
        methods: {
          newSurvey(){
            this.newSurveyButtonClass = "button-blue button-outline";
            this.fillSurveyButtonClass = "button-blue";
            this.statisticsButtonClass = "button-blue";
            this.mode = "new_survey";
          },
          fillSurvey(){
            if (this.surveyID == 0) {
              this.$emit("error", "no survey with such ID");
            } else {
              this.$emit("success", "");
            }
            this.newSurveyButtonClass = "button-blue";
            this.fillSurveyButtonClass = "button-blue button-outline";
            this.statisticsButtonClass = "button-blue";
            this.mode = "fill_survey";
          },
          statistics(){
            this.newSurveyButtonClass = "button-blue";
            this.fillSurveyButtonClass = "button-blue";
            this.statisticsButtonClass = "button-blue button-outline";
            this.mode = "statistics";
          }
        }
    };
</script>
<style lang="scss">
.button-blue {
  background-color: blue;
  border-color: blue;
}
.button-blue.button-clear,
.button-blue.button-outline {
  background-color: transparent;
  color: blue;
}
.button-blue.button-clear {
  border-color: transparent;
}
</style>