
<template>
  <div>
    <label for="warningMessageInput"></label>
    <input
      id="warningMessageInput"
      @keypress.enter="showMessage"
    />
  </div>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';


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

  private clearInput() {
    this.inputField.value = " ";
  }
}
</script>

<style scoped>

</style>
