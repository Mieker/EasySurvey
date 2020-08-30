<template>
    <div id="statistics">

        <table>
            <thead>
            <p1>wynik dla wybranej odpowiedzi:</p1>
            <p2 class="alert">{{prcResult}} %</p2>
            <tr>
                <td>treść pytania:</td>
                <td>sprawdz wynik:</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="question in survey.questions" :key="question.id">
                <td>{{question.questionText}}
                </td>
                <td>
                    <li v-for="potentialQuestionAnswer in question.potentialQuestionAnswers"
                        :key="potentialQuestionAnswer.id">
                        <button v-on:click="getStat2(question.id, potentialQuestionAnswer.id )">
                            {{potentialQuestionAnswer.text}}
                        </button>
                        <!--                        <p v-bind:click="onePrc(question.id, potentialQuestionAnswer.id )"></p>-->
                        <!--                        id:{{potentialQuestionAnswer.id}} {{prcResult}}-->
                    </li>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</template>

<script>
    export default {
        props: ["surveyId"],

        data() {
            return {
                survey: {
                    questionAnswers: [], metricAnswers: [], questions: [], metrics: [], description: ""
                },
                testee: "",
                questionId: "1",
                questionAnswerId: "2",
                prcResult: ""
            }
        },


        watch: {
            surveyId: function () {
                this.loadStat();
            }
        },

        methods: {

            // test() {
            //     this.$http.get('statistics/2')
            //         .then(response => {
            //             this.testOne = response.body;
            //             console.log('testOne ', response.status),
            //                 this.testee = response.bodyText
            //         });
            // },

            loadStat() {
                this.$http.get('survey/' + this.surveyId)
                    .then(response => {
                        this.survey = response.body;
                        this.success("Successfuly loaded survey no. " + this.surveyId + ": " + this.survey.description);
                    })
                    .catch(response => {
                        this.failure('Error ' + response.status + ' while loading the survey statistics. No such survey ID.');
                    })
            },


            getStat2(Qid, QAid) {
                this.$http.get('statistics/' + Qid + '/' + QAid)
                    .then(response => {
                        this.prcResult = response.body;
                    });
            },

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


        },

        mounted() {
            this.loadStat();
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
