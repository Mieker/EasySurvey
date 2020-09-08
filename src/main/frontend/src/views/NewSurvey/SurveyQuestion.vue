<template>
  <div class="surveyCreatorComponent">
      <p>QUESTION:</p>
      <OfferedSurveyAnswer/>
      <button class="button-blue">ADD ANSWER</button>
  </div>
</template>

<script>
import OfferedSurveyAnswer from './OfferedSurveyAnswer';

export default {
    components: {
        OfferedSurveyAnswer
    }
}
</script>

<style>

</style>