<template>
	<div>
		<br>
		<h5>{{question.questionText}}</h5>
		<div id="potential_answers" v-for="potentialQuestionAnswer in question.potentialQuestionAnswers" :key="potentialQuestionAnswer.id">
			<input type="radio" :id="potentialQuestionAnswer.id" :value="potentialQuestionAnswer.id" :name="question.id" v-model="picked">
			{{potentialQuestionAnswer.text}}
		</div>
	</div>
	
</template>

<script>

	export default {
      props: ["question"],
      
      data() {
          return {
			  message: "",
			  picked: [],
          }
	  },

	  methods: {
		success(message) {
          this.$emit("success", message);
        },

        failure(message) {
          this.$emit("error", message);
        },  
	  },
	  mounted(){
		  alert(question.text)
	  }
	}

</script>