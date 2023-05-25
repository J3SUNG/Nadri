<template>
  <div class="bar-chart">
    <Bar :options="Options" :data="chartData" style="max-height: 400px" />
  </div>
</template>
<script>
import http from "@/util/http-common";
import { Bar } from "vue-chartjs";
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from "chart.js";

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale);

export default {
  name: "BarChart",
  components: { Bar },
  props: {},
  data() {
    return {
      color: [],
      chartData: {
        labels: [], // x축에 들어갈 값
        datasets: [], // y축에 들어갈 값
      },
      Options: {
        indexAxis: "y",
        responsive: true,
        borderWidth: 1,
      },
      item: "",
    };
  },
  created() {
    http
      .get(`map/chart`)
      .then((response) => {
        this.item = response.data;
        console.log(this.item[0].title);
      })
      .then(() => {
        this.chartData = {
          labels: [
            this.item[0].title,
            this.item[1].title,
            this.item[2].title,
            this.item[3].title,
            this.item[4].title,
            this.item[5].title,
            this.item[6].title,
            this.item[7].title,
            this.item[8].title,
            this.item[9].title,
          ], // x축에 들어갈 값(수정해야됨)
          datasets: [
            {
              label: ["방문자수 "], // 그래프의 제목(수정해야됨)
              data: [
                this.item[0].cnt,
                this.item[1].cnt,
                this.item[2].cnt,
                this.item[3].cnt,
                this.item[4].cnt,
                this.item[5].cnt,
                this.item[6].cnt,
                this.item[7].cnt,
                this.item[8].cnt,
                this.item[9].cnt,
              ], // y축에 들어갈 값(수정해야됨)
              backgroundColor: [
                // 색상 적당히 파스텔 톤으로 구성됨
                "rgba(255, 99, 132, 0.6)",
                "rgba(54, 162, 235, 0.6)",
                "rgba(255, 206, 86, 0.6)",
                "rgba(75, 192, 192, 0.6)",
                "rgba(153, 102, 255, 0.6)",
                "rgba(255, 159, 64, 0.6)",
                "rgba(75, 192, 192, 0.6)",
              ],
            },
          ],
        };
      });
  },
  methods: {},
};
//
</script>

<style>
.bar-chart {
  padding: 20px;
}
</style>
