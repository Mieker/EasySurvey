<template>
  <div id="app">
    <div class="row">
      <img class="logo" src="./assets/logo.png" alt="Easy Survey by HashCodeTeam">
    </div>
    <div class="row messageColumn">
      <div class="column column-80">
        <transition name="bounce">
        <div v-bind:class="'alert alert-' + (this.isError ? 'error' : 'success')" v-if="message">{{ message }}</div>
        </transition>
      </div>
    </div>
    <survey-page v-if="selection" @error="failure($event)" @success="success($event)"></survey-page>
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
            }
        },
        methods:{
          failure(message){
            this.message = message;
            this.isError = true;
          },
          success(message) {
            this.message = message;
            this.isError = false;
          },
        }
    };
</script>

<style lang="scss">
  #app {
    display: flex;
    flex-direction: column;
    max-width: 1000px;
    margin: auto;
  }

  .messageColumn {
    display: flex;
    justify-content: center;
  }

  .logo {
      float:left;
      margin: auto;
  }

  .alert {
    padding: 10px;
    margin-bottom: 10px;
    border: 2px solid black;
    border-radius: 5px;
    &-success {
      background: lightgreen;
      border-color: darken(lightgreen, 10%);
      text-align: center;
    }
    &-error {
      background: indianred;
      border-color: darken(indianred, 10%);
      color: white;
      text-align: center;
    }
  }
  .bounce-enter-active {
    animation: bounce-in .5s;
  }
  .bounce-leave-active {
    animation: bounce-in .5s reverse;
  }
  @keyframes bounce-in {
    0% {
      transform: scale(0);
    }
    50% {
      transform: scale(1.5);
    }
    100% {
      transform: scale(1);
    }
}
</style>

