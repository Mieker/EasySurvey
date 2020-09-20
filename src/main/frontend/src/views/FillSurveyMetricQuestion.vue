<template>
	<div>
		<h5><b>{{metricQuestion.metricText}}</b></h5>
		<div id="potential_answers" v-for="potentialMetricAnswer in metricQuestion.potentialMetricAnswers" :key="potentialMetricAnswer.id">
			<input type="radio" :id="potentialMetricAnswer.id" :value="potentialMetricAnswer.id" :name="metricQuestion.id" v-model="picked">
			<span text-align="left">{{potentialMetricAnswer.text}}</span>
		</div>
		<br>
	</div>
	
</template>

<script>

	export default {
      props: ["metricQuestion"],
      
      data() {
          return {
			  picked: 0,
			  message: "",
			  metricAnswer: {metricQuestionId: 0, metricAnswerId: 0},
          }
	  },

	  watch: { 
        picked: function() {
		  this.selectionChanged();
        }
      },

	  methods: {

		selectionChanged(){
			this.metricAnswer.metricQuestionId = this.metricQuestion.id;
			this.metricAnswer.metricAnswerId = this.picked;
			this.$emit("selected", this.metricAnswer);
		},

		

		success(message) {
          this.$emit("success", message);
        },

        failure(message) {
          this.$emit("error", message);
        },  
	  },
	}

</script>

<style lang="scss">

</style>