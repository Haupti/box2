
<template>
  <div>
    <input
      id="warningMessageInput"
      @keypress.enter="showMessage"
    >
    <button
      id="restRequest"
      @click="requestMessage"
    >
      REST request
    </button>
  </div>
</template>

<script lang="ts">
/*eslint no-unused-vars: "warn"*/
import {Options, Vue} from 'vue-class-component';
import axios, {AxiosResponse} from 'axios';

@Options({
  props: {
    name: String,
  },
  emits: {
    warningMessage(payload: string): string {
      return payload;
    },
  },
})
export default class MessageCreator extends Vue {

  private inputField!: HTMLInputElement;

  mounted(): void {
    this.inputField = (document.getElementById("warningMessageInput") as HTMLInputElement);
  }

  showMessage(): void {
    const message: string = this.inputField.value;
    this.clearInput();
    this.$emit("warningMessage", message);
  }

  requestMessage(): void {
    this.request();
  }

  async request() {
    await axios("http://0.0.0.0:5006/REST", {headers: {'Access-Control-Allow-Origin': '*',}})
        .then((response: AxiosResponse) => {
          console.log(response.data);
          this.$emit("requestMessage", response.data);
        });
  }


  private clearInput() {
    this.inputField.value = " ";
  }
}
</script>

<style scoped>

</style>
