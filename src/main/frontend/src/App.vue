<template>
  <div id="app">
	<h1>
        <img src="./assets/logo.png">
      {{welcome}}
    </h1>
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
    margin: 0 auto;
  }

  .logo {
    vertical-align: middle;
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

