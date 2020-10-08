<template>
  <div id="app">
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <div class="row" @click="reloadPage()">
      <img class="logo" src="./assets/logo.png" alt="Easy Survey by HashCodeTeam">
    </div>
    <div class="row messageColumn">
      <div class="column column-80">
        <transition name="bounce">
        <div v-bind:class="'alert alert-' + this.status" v-if="message">{{ message }}</div>
        </transition>
      </div>
    </div>
    <survey-page v-if="selection" @warning="warning($event)" @error="failure($event)" @success="success($event)"></survey-page>
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
                status: "success",
                message: ''
            }
        },
        methods:{
          messageDelay(sec){
            setTimeout(()=>{this.message=""}, sec*1000);
          },
          failure(message){
            this.message = message;
            this.status = "error";
            this.messageDelay(3);
          },
          success(message) {
            this.message = message;
            this.status = "success";
            this.messageDelay(3);
          },
          warning(message) {
            this.message = message;
            this.status = "warning";
          },
          reloadPage() {
            location.reload();
          }
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
    position: fixed;
    top: 10px;
    left: 10px;
    display: flex;
    justify-content: center;
  }

  .logo {
      float:left;
      margin: auto;
  }
  .logo:hover {
    cursor: pointer;
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
    &-warning {
      background: yellow;
      border-color: darken(yellow, 10%);
      color: blue;
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
.surveyCreatorComponent {
    border: 1px solid #135A7A;
    // box-shadow: 2px 2px 5px cornflowerblue;
    margin: 5px;
    padding: 2px;
    border-radius: 5px;
    text-align: left;
}

.componentFulfillment {
    background-color: #135A7A;
}

.mainNames {
    font-family:"Roboto";
    font-size: 90%;
    font-weight: bold;
    //text-transform: uppercase;
    color: #FFFFFF;
    background-color: #135A7A;
    text-align: center;
    padding: 0.5%;
    border-radius: 5px;
}

// #createSurveyButton {
//     float: right;
//     margin-right: 5px;
//     margin-top: 5px;
//     background-color: coral;
// }

// #createSurveyButton:hover {
//     background-color: gray;
// }

.listContainer {
    display: flex;
}

.listContainer:hover {
    background-color: #F5A528;
    color: #203C4A;
}

.mainButtonsPanel button {
    min-width: 180px;
}

@media (max-width: 650px) {
    .mainButtonsPanel div {
        display: flex;
        margin: auto;
        align-content: center;
    }
}

@media (min-width: 651px) {
    .mainButtonsPanel {
        display: flex;
        justify-content: space-around;
    }
}

.inputSurveyIdPanel {
    display: flex;
    justify-content: center;
}

.button-blue {
    background-color: #203C4A;
    border-color: #203C4A;

    &.button-clear,
    &.button-outline {
        background-color: transparent;
        color: #203C4A;
    }

}

.button-blue:hover {
    background-color: #80B7D6;
    border-color: #203C4A;
    color: #203C4A;
}

.button-yellow {
    background-color: #F5A528;
    border-color: #203C4A;
    color: #203C4A;
    float: right;

    &.button-clear,
    &.button-outline {
        background-color: transparent;
        color: #F5A528;
    }

}

.button-yellow:hover {
    background-color: #80B7D6;
    border-color: #203C4A;
    color: #203C4A;
}

.button-blue.button-clear {
    border-color: transparent;
}

.fade-enter-active,
.fade-leave-active {
    transition: opacity .5s;
}

.fade-enter,
.fade-leave-to

/* .fade-leave-active below version 2.1.8 */
    {
    transition: opacity .5s;
}

input[type=text]{
-webkit-appearance: none;
  background-color: transparent;
  border: 0.1rem solid #80B7D6;
  border-radius: .4rem;
  box-shadow: none;
  box-sizing: inherit;
  height: 3.8rem;
  padding: .6rem 1.0rem .7rem; //width: 100%;
}
input[type=text]:focus {
  border: 0.1rem solid #F5A528;
}

input[type="radio"] {
  /* remove standard background appearance */
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  /* create custom radiobutton appearance */
  display: inline-block;
  width: 20px;
  height: 20px;
  padding: 3px;
  /* background-color only for content */
  background-clip: content-box;
  border: 2px solid #203C4A;
  background-color: #FFFFFF;
  border-radius: 50%;
}

/* appearance for checked radiobutton */
input[type="radio"]:checked {
  background-color: #F5A528;
}

/* optional styles, I'm using this for centering radiobuttons */
.flex {
  display: flex;
  align-items:top;
}

textarea{
  -webkit-appearance: none;
  background-color: transparent;
  border: 0.1rem solid #80B7D6;
  border-radius: .4rem;
  box-shadow: none;
  box-sizing: inherit;
  height: 3.8rem;
  padding: .6rem 1.0rem .7rem;
  //width: 100%;
}
textarea:focus{
  border: 0.1rem solid #F5A528;
}

font-awesome-icon {
    color: #135A7A;
}

.fasDiv {
    margin-right: 10px;
}

.fasDiv:hover {
    color: white;
}

.innerListContainer {
    width: 100%;
    display: flex;
    justify-content: space-between;
    padding-left: 10px;
    padding-right: 10px;
}

.idSpan {
    width: 100px;
    margin-right: 100px;
    text-align: left;
}

</style>

