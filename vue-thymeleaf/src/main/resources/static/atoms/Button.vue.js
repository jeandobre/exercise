Vue.component("Button", {
	inheritAttrs: true,
	template: `
		<button type="button" v-bind="$attrs" v-on:click="$emit('click')" >
			<slot>Button</slot>
		</button>
	`,
});