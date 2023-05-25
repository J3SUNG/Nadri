<template>
  <LineGen id="my-chart-id" :options="chartOptions" :data="chartData"></LineGen>
</template>

<script>
// import http from "@/util/http-common";
import { Line as LineGen } from "vue-chartjs";
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  LineElement,
  LinearScale,
  CategoryScale,
  PointElement,
} from "chart.js";

ChartJS.register(Title, Tooltip, Legend, LineElement, LinearScale, CategoryScale, PointElement);

export default {
  name: "LineChart",
  components: { LineGen },
  props: {
    chartData: {
      type: Object,
      required: true,
    },
    chartOptions: {
      responsive: true,
    },
  },
  data() {
    return {};
  },
};
</script>
