<template>
<div>
    <p class="mainNames">LATEST SURVEYS</p>
    <ul>
        <li class="listContainer" v-for="survey in latestSurveys" v-bind:key="survey">
          <span>{{ survey[0] }}</span><span>ID: {{ survey[1] }}</span>
        </li>
    </ul>
</div>
</template>

<script>
export default {
    data() {
        return {
            latestSurveys: []
        }
    },
    mounted() {
        this.loadLatestSurveys();
    },
    methods: {
        loadLatestSurveys() {
            this.$http.get('survey/latest').then(response => {
                this.latestSurveys = response.body;
            }, response => {
                // error callback
            });
        }
    }

}
</script>

<style>

</style>
