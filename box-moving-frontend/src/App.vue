<template>
  <div id="app"
      @keypress.up="boxUp"
      @keypress.down="boxDown"
      @keypress.left="boxLeft"
      @keypress.right="boxRight">
    <div class="cols">
      <div class="colFirst">
        <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
        <Display name="HTMLCanvas" v-bind:warningMsg="warning" v-bind:x="x" v-bind:y="y" />
        <MessageCreator name="MessageCreator" @warningMessage="setWarning" @requestMessage="alertMessage" />
      </div>
      <div class="colSecond">
        <RestTester />
        <QuoteAdder />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';
import HelloWorld from './components/HelloWorld.vue';
import Display from './components/Display.vue';
import MessageCreator from "@/components/MessageCreator.vue";
import RestTester from "@/components/RestTester.vue";
import QuoteAdder from "@/components/QuoteAdder.vue";

@Options({
  components: {
    HelloWorld,
    Display,
    MessageCreator,
    RestTester,
    QuoteAdder,
  },
})

export default class App extends Vue {
  warning = "";
  x = 0;
  y = 0;

  mounted() {
    // eslint-disable-next-line @typescript-eslint/no-this-alias
    const self = this;

    window.addEventListener('keypress', function (this: Window, event: KeyboardEvent) {
      if (event.code == "KeyS") {
        self.boxDown();
      } else if (event.code == "KeyW") {
        self.boxUp();
      } else if (event.code == "KeyA") {
        self.boxLeft();
      } else if (event.code == "KeyD") {
        self.boxRight();
      }
    });
  }

  setWarning(message: string): void {
    this.warning = message;
  }

  alertMessage(message: string): void {
    alert(message)
  }

  boxUp(): void {
    this.y -= 20;
  }

  boxDown(): void {
    this.y += 20;
  }

  boxLeft(): void {
    this.x -= 20;
  }

  boxRight(): void {
    this.x += 20;
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.cols {
  display: flex;
}
</style>
