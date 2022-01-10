Vue.component("PrimaryButton", {
	props: ["title", "name"],
	template: `
		<button type="button" class="btn btn-primary" :title="title" :name="name" v-on:click="$emit('click')">
			<slot>Button</slot>
		</button>
	`,
});