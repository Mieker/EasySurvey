<template>
  <div id="app">
    <img class="logo" src="./assets/logo.png" alt="Easy Survey by HashCodeTeam">
    <div :class="'alert alert-' + (this.isError ? 'error' : 'success')" v-if="message">{{ message }}</div>
    <survey-page v-if="selection"></survey-page>
  </div>
</template>

<script>
    import "milligram";
    import Vue from "vue";
    import SurveyPage from "./SurveyPage";

    export default {
        components: {SurveyPage},
        data() {
            return {
                selection: true,
                isError: false,
                message: ''
            };
        },
    };
</script>

<style lang="scss">
  #app {
    max-width: 1000px;
  }

  .logo {
      float:left;
      margin:0;
  }

  .alert {
    padding: 10px;
    margin-bottom: 10px;
    border: 2px solid black;
    &-success {
      background: lightgreen;
      border-color: darken(lightgreen, 10%);
    }
    &-error {
      background: indianred;
      border-color: darken(indianred, 10%);
      color: white;
    }
  }

</style>

