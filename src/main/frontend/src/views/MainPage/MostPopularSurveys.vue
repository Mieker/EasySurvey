<template>
<div>
    <p class="mainNames">MOST POPULAR SURVEYS</p>
    <ul>
        <li class="listContainer" v-for="survey in mostPopularSurveys" v-bind:key="survey">
            <span>{{ survey[0] }}</span><span>ID: {{ survey[1] }}</span>
        </li>
    </ul>
</div>
</template>

<script>
export default {
    data() {
        return {
            mostPopularSurveys: []
        }
    },
    mounted() {
        this.loadMostPopularSurveys();
    },
    methods: {
        loadMostPopularSurveys() {
            this.$http.get('survey/most_popular').then(response => {
                this.mostPopularSurveys = response.body;
            }, response => {
                //error
            });
        }
    }

}
</script>

<style>

</style>
