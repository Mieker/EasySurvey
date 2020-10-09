<template>
    <div id="statistics">
        <br>
        <h4>Total number of voters: <b>{{statistic.numberOfAnswers}}</b></h4>
        <div class="surveyCreatorComponent">
            <p class="mainNames">Survey statistics</p>

<!--            <h1>-->
<!--                {{chosenMetrics}} {{dupa}}-->
<!--            </h1>-->

            <table class="d">
                <caption>Metric filter:</caption>
                <tr>
                    <td class="wide">Metric Question:</td>
                    <td>Metrics Filter:</td>

                </tr>
                <tr v-for="metric in statistic.survey.metrics" :key="metric.id">
                    <td>{{ metric.metricText }}</td>
                    <td>
                        <table class="e">
                            <tbody>
                            <td v-for="potentialMetricAnswer in metric.potentialMetricAnswers" :key="metric.id">
                                {{potentialMetricAnswer.text}}
                                <input type="checkbox" v-model="chosenMetrics" :value="potentialMetricAnswer.id">
                            </td>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </table>


            <!--            <table class="d">-->
            <!--                <caption>Metric filter:</caption>-->
            <!--                <tr>-->
            <!--                    <td class="wide">Metric Question:</td>-->
            <!--                    <td>Metrics Filter:</td>-->
            <!--                </tr>-->
            <!--                <tr v-for="metric in statistic.survey.metrics" :key="metric.id">-->
            <!--                    <td>{{ metric.metricText }}</td>-->
            <!--                    <td>-->
            <!--                        <table class="e">-->
            <!--                            <tbody>-->
            <!--                            <td v-for="potentialMetricAnswer in metric.potentialMetricAnswers" :key="metric.id">-->
            <!--                                {{potentialMetricAnswer.text}}-->
            <!--                                <input type="checkbox" v-model="chosenMetrics" :value="potentialMetricAnswer.id">-->
            <!--                            </td>-->
            <!--                            </tbody>-->
            <!--                        </table>-->
            <!--                    </td>-->


            <!--            </table>-->


<!--            <button @click="loadStat()">see statistics</button>-->

            <table class="d">
                <caption>Question statistics:</caption>
                <thead>
                <tr>
                    <td class="wide">Question:</td>
                    <td>Question Statistics:</td>
                </tr>
                </thead>
                <tbody>
                <tr v-for="question in statistic.questionStats" :key="question.id">
                    <td>{{question.questionText}}</td>
                    <td>
                        <table>
                            <tr>
                                <th>Possible answer:</th>
                                <th class="innerTableWidth">%</th>
                                <th class="innerTableWidth">Votes:</th>
                            </tr>
                            <tbody>
                            <tr v-for="potentialQuestionAnswer in question.answerStats"
                                :key="potentialQuestionAnswer.id">
                                <td>{{potentialQuestionAnswer.potentialQuestionAnswer.text}}</td>
                                <td align="center">{{Math.round(((potentialQuestionAnswer.numberOfAnswers /
                                    question.numberOfMetricAnswers) + Number.EPSILON) *10000)/100}} %
                                </td>
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
                dupa: [],
                // questionId: "1",
                // questionAnswerId: "2",
                // prcResult: ""
            }
        },

        created() {
            //this.loadTest();
            //this.fill()
        },

        watch: {
            surveyId: function () {
                //this.loadStat();
                this.loadTest();
                //this.fill();
            },

            chosenMetrics: function(){
                //this.test()
                this.loadStat();
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

            // loadStat() {
            //     this.warning("loading...")
            //     this.$http.get('statistics/' + this.surveyId)
            //         .then(response => {
            //             this.statistic = response.body;
            //             this.success("Successfuly loaded survey no. " + this.statistic.surveyId + ": " + this.statistic.surveyDescription);
            //         })
            //         .catch(response => {
            //             this.failure('Error ' + response.status + ' while loading the survey statistics. No such survey ID.');
            //         })
            // },

            loadTest() {
                //
                this.warning("loading...");
                //this.fill();
                //this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => this.response = response.body);
                this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => {
                    this.statistic = response.body;
                    this.fill();
                    this.loadStat()
                });
                //this.fill();
            },

            loadStat() {
                //
                this.warning("loading...");
                //this.fill();
                //this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => this.response = response.body);
                this.$http.post('statistics/' + this.surveyId + '/metrics', this.chosenMetrics).then(response => {
                    this.statistic = response.body;
                });
                //this.fill();
            },

            fill() {
                //this.text = this.metrics.metricsStats[0].metricAnswerStats[0].potentialMetricsAnswer.id
                for (var i in this.statistic.survey.metrics) {
                    for (var j in this.statistic.survey.metrics[i].potentialMetricAnswers) {
                        this.chosenMetrics.push(this.statistic.survey.metrics[i].potentialMetricAnswers[j].id);
                    }
                }

            },

            test(){
                this.dupa += 1
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
            //this.fill();
            this.loadTest()

        },

        computed() {
            this.fill();


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

    table, th, td {
        border-collapse: collapse;
        text-align: center;
    }

    th, td {
        padding: 5px;
    }


    table.d {
        table-layout: fixed;
        margin-left: auto;
        margin-right: auto;
        width: 95%;
    }

    table.e {
        table-layout: fixed;
        margin-left: auto;
        margin-right: auto;
        width: 100%;
        padding: 0;
    }

    .wide {
        width: 25%;
    }

    .innerTableWidth {
        width: 12%;
        min-width: 100px;
    }


</style>
