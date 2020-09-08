<template>
<div id="new_survey">
    <h3 style="text-align: center">{{message}}</h3>
    <CreateMetric />
    <p></p>
    <CreateSurvey />
    <button class="button-blue" id="createSurveyButton">CREATE EASY SURVEY</button>
</div>
</template>

<script>
import CreateMetric from './NewSurvey/CreateMetric';
import CreateSurvey from './NewSurvey/CreateSurvey';

export default {
    components: {
        CreateMetric,
        CreateSurvey
    },
    data() {
        return {
            message: "Create your survey:",
            survey: {

            }
        }
    },
};
</script>

<style>

.surveyCreatorComponent {
    border: 1px solid cornflowerblue;
    box-shadow: 2px 2px 5px cornflowerblue;
    margin: 5px;
    padding: 2px;
    text-align: center;
}
.componentFulfillment {
    background-color: deepskyblue;
}

#createSurveyButton {
    float: right;
    background-color: coral;
}


</style>