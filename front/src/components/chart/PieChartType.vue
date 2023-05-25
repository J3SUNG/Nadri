<template>
  <div class="chart-view__pie-type">
    <Pie :opdtions="chartOptions" :data="chartData" style="max-height: 300px" />
  </div>
</template>
<script>
import { Pie } from "vue-chartjs";

import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale } from "chart.js";
import http from "@/util/http-common";

ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale);
export default {
  name: "PieChartType",
  components: { Pie },
  props: {},
  data() {
    return {
      chartData: {
        labels: this.gender,
        datasets: [
          {
            label: "여행 타입", //그래프의 제목
            backgroundColor: [], // 그래프의 색상
            data: this.gender_data,
          },
        ],
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
      },
      type: {
        12: 0,
        14: 0,
        15: 0,
        25: 0,
        28: 0,
        32: 0,
        38: 0,
        39: 0,
      },
    };
  },
  created() {
    http
      .get(`map/chart`)
      .then((response) => {
        let logData = response.data;

        for (let i = 0; i < logData.length; ++i) {
          ++this.type[logData[i].contentType];
        }
      })
      .then(() => {
        this.chartData = {
          labels: ["관광지", "문화시설", "행사", "여행코스", "레포츠", "숙박", "쇼핑", "음식점"],
          datasets: [
            {
              label: "Count", // 그래프의 제목(값만 수정하면됨)
              backgroundColor: [
                // 색상 적당히 구성 됨.
                "rgba(255, 99, 132, 0.8)",
                "rgba(54, 162, 235, 0.8)",
                "rgba(255, 99, 132, 0.8)",
                "rgba(54, 162, 235, 0.8)",
                "rgba(255, 206, 86, 0.8)",
                "rgba(75, 192, 192, 0.8)",
                "rgba(153, 102, 255, 0.8)",
                "rgba(255, 159, 64, 0.8)",
                "rgba(255, 206, 86, 0.8)",
                "rgba(153, 102, 255, 0.8)",
                "rgba(54, 162, 235, 0.8)",
                "rgba(255, 159, 64, 0.8)",
                "rgba(255, 99, 132, 0.8)",
                "rgba(75, 192, 192, 0.8)",
              ],
              data: [
                this.type[12],
                this.type[14],
                this.type[15],
                this.type[25],
                this.type[28],
                this.type[32],
                this.type[38],
                this.type[39],
              ], // 그래프에 들어가는 실제 값 value(값만 수정하면 됨) - 값에 따라 자동으로 비율 설정
            },
          ],
        };
        this.chartOptions = {
          responsive: true,
          maintainAspectRatio: false,
        };
      });
  },
  methods: {},
};
</script>

<style>
.chart-view__pie-type {
  padding: 20px;
}
</style>
