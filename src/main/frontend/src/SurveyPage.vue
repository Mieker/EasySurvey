<template>
  <div id="survey_page">

    <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">

    <transition
    name="custom-classes-transition"
    enter-active-class="animated bounceInRight"
    leave-active-class="animated bounceOutRight"
    >
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
    </transition>

  
      <div class="row">
        <div class="column"><button v-bind:class = "newSurveyButtonClass" @click="newSurvey()">create a survey</button></div>
        <div class="column"><button v-bind:class = "fillSurveyButtonClass" @click="fillSurvey()">fill a survey</button></div>
        <div class="column"><button v-bind:class = "statisticsButtonClass" @click="statistics()">see statistics</button></div>
      </div>
    

    <new-survey v-if="mode==='new_survey'"></new-survey>
    <fill-survey v-if="mode==='fill_survey'"></fill-survey>
    <statistics v-if="mode==='statistics'"></statistics>
  
  </div>

</template>

<script>
  import NewSurvey from "./views/NewSurvey";
  import FillSurvey from "./views/FillSurvey";
  import Statistics from "./views/Statistics";
  
  export default {
    components: {NewSurvey, FillSurvey, Statistics},  
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
        this.$emit("success", "");
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
        if (this.surveyID == 0) {
          this.$emit("error", "no survey with such ID");
        } else {
          this.$emit("success", "");
        }
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

.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>