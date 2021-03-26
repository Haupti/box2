<template>
  <div>
    <div>
      <label for="authorInput"></label><input id="authorInput" />
      <label for="quoteInput"></label><input id="quoteInput" />
      <button id="sendQuote" onclick="persistQuote">send quote</button>
    </div>
    <div>
      <p id="quoteDisplay"></p>
    </div>
  </div>
</template>

<script lang="ts">
/*eslint no-unused-vars: "warn"*/
import {Options, Vue} from "vue-class-component";
import axios, {AxiosResponse} from "axios";

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

export default class QuoteAdder extends Vue {
  name: "QuoteAdder" | undefined

  private requestData: string | undefined;

  async persistQuote() {
    await axios.post("http://0.0.0.0:5006/quotes", {
      headers: {'Access-Control-Allow-Origin': '*',},
      quote: {
        author: document.getElementById("authorInput"),
        quote: document.getElementById("quoteInput")
      }
    })
    await this.request();
  }

  async request() {
    await axios.get("http://0.0.0.0:5006/quotes",
        {headers: {'Access-Control-Allow-Origin': '*',}})
        .then((response: AxiosResponse) => {
          this.requestData = response.data;
          (document.getElementById("quoteDisplay") as HTMLElement).textContent =
              this.requestData || "nothing fetched";
          alert();
          alert(this.requestData)
        });
  }
}
</script>

<style scoped>

</style>
