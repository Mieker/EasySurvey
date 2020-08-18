<template>
	<div>
		<h5>{{question.questionText}}</h5>
		<div id="potential_answers" v-for="potentialQuestionAnswer in question.potentialQuestionAnswers" :key="potentialQuestionAnswer.id">
			<input type="radio" :id="potentialQuestionAnswer.id" :value="potentialQuestionAnswer.id" :name="question.id" v-model="picked">
			<span>{{potentialQuestionAnswer.text}}</span>
		</div>
		<br>
	</div>
	
</template>

<script>

	export default {
      props: ["question"],
      
      data() {
          return {
			  picked: 0,
			  message: "",
			  answer: {questionId: 0, answerId: 0},
          }
	  },

	  watch: { 
        picked: function() {
		  this.selectionChanged();
        }
      },

	  methods: {

		selectionChanged(){
			this.answer.questionId = this.question.id;
			this.answer.answerId = this.picked;
			this.$emit("selected", this.answer);
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