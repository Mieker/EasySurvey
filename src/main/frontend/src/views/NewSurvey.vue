<template>
<div id="new_survey">
    <DescriptionPanel />
    <p></p>
    <CreateMetric />
    <p></p>
    <CreateSurvey />
    <button class="button-blue" id="createSurveyButton">CREATE EASY SURVEY</button>
</div>
</template>

<script>
import CreateMetric from './NewSurvey/CreateMetric';
import CreateSurvey from './NewSurvey/CreateSurvey';
import DescriptionPanel from './NewSurvey/DescriptionPanel';

export default {
    components: {
        CreateMetric,
        CreateSurvey,
        DescriptionPanel
    },
    data() {
        return {
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
    margin-right: 5px;
    margin-top: 5px;
    background-color: coral;
}

#createSurveyButton:hover {
    background-color: gray;
}


</style>