<template>
  <div>
    <canvas id="chart" width="400" height="400"></canvas>
  </div>
</template>

<script>
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from "chart.js";
Chart.register(BarElement, BarController, LinearScale, CategoryScale);
export default {
  name: "LineChart",
  methods: {
    fillData() {
      const ctx = document.getElementById("chart").getContext("2d");
      this.myChart = new Chart(ctx, {
        type: "line",
        data: {
          labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
          datasets: [
            {
              label: "# of Votes",
              data: [12, 19, 3, 5, 2, 3],
              backgroundColor: [
                "rgba(255, 99, 132, 0.2)",
                "rgba(54, 162, 235, 0.2)",
                "rgba(255, 206, 86, 0.2)",
                "rgba(75, 192, 192, 0.2)",
                "rgba(153, 102, 255, 0.2)",
                "rgba(255, 159, 64, 0.2)",
              ],
              borderColor: [
                "rgba(255, 99, 132, 1)",
                "rgba(54, 162, 235, 1)",
                "rgba(255, 206, 86, 1)",
                "rgba(75, 192, 192, 1)",
                "rgba(153, 102, 255, 1)",
                "rgba(255, 159, 64, 1)",
              ],
              borderWidth: 1,
            },
          ],
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });
    },
  },
  mounted() {
    this.fillData();
  },
  data() {
    return {
      myChart: null,
    };
  },
};
</script>

<style scoped></style>
