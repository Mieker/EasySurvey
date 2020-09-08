<template>
<div class="surveyCreatorComponent">
    <p class="mainNames">QUESTIONS CREATOR PANEL</p>
    <SurveyQuestion/>
    <button class="button-blue">ADD QUESTION</button>
</div>
</template>

<script>
import SurveyQuestion from './SurveyQuestion';

export default {
    components: {
        SurveyQuestion
    }
}
</script>

<style>

</style>
