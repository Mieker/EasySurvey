<template>
  <div id="app">
	<h1>
        <img id="logo" src="./assets/logo.png">
    </h1>
      <p> {{welcome}}</p>
  </div>

</template>

<script>
    import "milligram";
    import Vue from "vue";

    export default {
        data() {
            return {
                welcome: "Easy Survey by #CODE",
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

