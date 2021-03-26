<template>
  <div>
    <p
        id="dataDisplay"
    >
    </p>
    <button
        id="request"
        @click="request"
    >
      REST request
    </button>
  </div>
</template>

<script lang="ts">
/*eslint no-unused-vars: "warn"*/
import {Vue} from "vue-class-component";
import axios, {AxiosResponse} from "axios";

export default class RestTester extends Vue {
  name!: "RestTester";
  private requestData: string | undefined;

  mounted() {
    this.request();
  }

  async request() {
    await axios("http://0.0.0.0:5006/counter", {headers: {'Access-Control-Allow-Origin': '*',}})
        .then((response: AxiosResponse) => {
          this.requestData = response.data;
          (document.getElementById("dataDisplay") as HTMLElement).textContent =
              this.requestData || "nothing fetched";
        });
  }
}
</script>

<style scoped>

</style>
