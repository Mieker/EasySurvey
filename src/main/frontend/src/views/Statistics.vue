<template>
    <div id="statistics">
        <br>
        <h4>Total number of voters: <b>{{statistic.numberOfAnswers}}</b></h4>
    <div class="surveyCreatorComponent" >
        <p class="mainNames">Survey statistics</p>

        <h1>
            {{chosenMetrics}}
        </h1>

        <table style="width:100%;table-layout:fixed;">
            <tr>
                <td style="font-weight: bold" align="center">Question:</td>
                <td style="font-weight: bold" align="center">Metrics:</td>
            </tr>

            <tr v-for="metric in statistic.survey.metrics" :key="metric.id" >
                <td>{{ metric.metricText }}</td>
                <td v-for="potentialMetricAnswer in metric.potentialMetricAnswers" :key="metric.id">
                    {{potentialMetricAnswer.text}}
                    <div ></div>
                    <input type="checkbox" v-model="chosenMetrics" :value="potentialMetricAnswer.id"  >

                </td>
            </tr>


        </table>
        <button @click="loadTest()">see statistics</button>

        <table>
            <tr>
                <td style="font-weight: bold" align="center">Question:</td>
                <td style="font-weight: bold" align="center">Answers:</td>
            </tr>
            <tbody>

            <tr v-for="question in statistic.questionStats" :key="question.id">
                <td>{{question.questionText}}</td>
                <td>
                    <table>
                        <thead>
                        <td>Possible answer:</td>
                        <td align="center">Percentage:</td>
                        <td align="center">No. of quotes:</td>
                        </thead>
                        <tbody>
                        <tr v-for="potentialQuestionAnswer in question.answerStats" :key="potentialQuestionAnswer.id">

                            <td>{{potentialQuestionAnswer.potentialQuestionAnswer.text}}</td>
                            <td align="center">{{Math.round(((potentialQuestionAnswer.numberOfAnswers / question.numberOfMetricAnswers) + Number.EPSILON) *10000)/100}} %</td>
                            <td align="center">{{potentialQuestionAnswer.numberOfAnswers}}</td>

                        </tr>
                        </tbody>

                    </table>

                </td>

            </tr>


            </tbody>
        </table>
    </div>
    </div>
</template>

<script>
    export default {
        props: ["surveyId"],

        data() {
            return {
                // statistic: {
                //     questionAnswers: [], metricAnswers: [], questions: [], metrics: [], description: ""
                // },
                statistic: "",
                chosenMetrics: [],
                response: [],
                // questionId: "1",
                // questionAnswerId: "2",
                // prcResult: ""
            }
        },

        created: function(){
            this.chosenMetrics.push()
        },

        watch: {
            surveyId: function () {
                //this.loadStat();
                this.loadTest();
            }
        },

        methods: {

            // test() {
            //     this.$http.get('statistics/' + this.surveyId)
            //         .then(response => {
            //             this.testee = response.body;
            //             console.log('testOne ', response.status);
            //                 // this.testee = response.bodyText
            //         });
            // },

            test(){
                this.chosenMetrics.push(3);
            },

            loadStat() {
                this.warning("loading...")
                this.$http.get('statistics/' + this.surveyId)
                    .then(response => {
                        this.statistic = response.body;
                        this.success("Successfuly loaded survey no. " + this.statistic.surveyId + ": " + this.statistic.surveyDescription);
                    })
                    .catch(response => {
                        this.failure('Error ' + response.status + ' while loading the survey statistics. No such survey ID.');
                    })
            },

            loadTest() {
                this.warning("loading...")
                //this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => this.response = response.body);
                this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => this.statistic = response.body);
            },


            // getStat2(Qid, QAid) {
            //     this.$http.get('statistics/' + Qid + '/' + QAid)
            //         .then(response => {
            //             this.prcResult = response.body;
            //         });
            // },

            // onePrc: function (Qid, QAid) {
            //     this.$http.get('statistics/' + Qid + '/' + QAid)
            //         .then(response => {
            //             this.prcResult = response.body;
            //         });
            // },


            success(message) {
                this.$emit("success", message);
            },

            failure(message) {
                this.$emit("error", message);
            },

            warning(message) {
                this.$emit("warning", message);
            },

        },

        mounted() {
            //this.loadStat();
            this.loadTest();
        },


    };
</script>

<style lang="scss">
    #app {
        max-width: 1000px;
        margin: 0 auto;
    }

    .alert {
        padding: 10px;
        margin-bottom: 10px;
        border: 3px solid black;
    }

    .questions {
        display: flex;

        &-item {
            border: solid blue 2px;
            border-radius: 25px;
            padding: 10px;
            text-align: center;
            background-color: violet;
            color: darkblue;
            font-size: 2rem;
            margin: 10px;
            flex: 1;

            &:hover {
                background-color: blue;
                color: white;
                cursor: pointer;
            }
        }
    }


</style>
