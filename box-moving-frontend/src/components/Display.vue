<template>
  <div>
    <h1>{{ warningMsg }}</h1>
    <canvas id="canvas" class="canvas" tabindex="1"
            @keyup.enter="drawRect"
            @keyup.space="clearRect"
            width="1920"
            height="1080"
    ></canvas>
  </div>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';

@Options({
  props: {
    name: String,
    warningMsg: String,
    x: Number,
    y: Number,
  },
})

export default class Display extends Vue {
  private canvas!: HTMLCanvasElement;
  private vueCanvas: CanvasRenderingContext2D | null | undefined;
  warningMsg!: string;
  x!: number;
  y!: number;

  mounted() {
    const canvas: HTMLCanvasElement = document.getElementById('canvas') as HTMLCanvasElement;
    const ctx = canvas.getContext('2d');
    this.canvas = canvas;
    this.vueCanvas = ctx;

  }

  updated() {
    this.clearDisplay();
    this.drawRect(this.x, this.y);
    this.showMessage(this.warningMsg);
  }

  drawRect(x: number, y: number): void {
    this.vueCanvas?.beginPath();
    this.vueCanvas?.rect(x, y, 100, 100);
    this.vueCanvas?.stroke();
  }

  clearRect(height: number, width: number): void {
    this.vueCanvas?.clearRect(0, 0, height, width);
  }

  clearDisplay(){
    this.vueCanvas?.clearRect(0, 0, this.canvas?.width, this.canvas?.height);
  }

  showMessage(message: string): void {
    this.vueCanvas?.strokeText(message, 10, 10);
  }
}
</script>

<style scoped>

.canvas {
  background-color: #2c3e50;
  width: 70%;
  height: 39%;
}

</style>
