Vue.component("Navigation", {
  template: `
      <div>
        <h1>{{info}}</h1>
      </div>
  `,
  
  props: ["info"]
});