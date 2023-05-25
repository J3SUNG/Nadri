<template>
  <div class="chart-view__doughnut-sido">
    <Doughnut :opdtions="chartOptions" :data="chartData" style="max-height: 300px" />
    <p class="chart-view__doughnut-sido__text">1등: {{ winSido }}</p>
  </div>
</template>
<script>
import { Doughnut } from "vue-chartjs";

import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale } from "chart.js";
import http from "@/util/http-common";

ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale);
export default {
  name: "DoughnutChart",
  components: { Doughnut },
  props: {},
  data() {
    return {
      chartData: {
        labels: this.gender,
        datasets: [
          {
            label: "여행 시도", //그래프의 제목
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
        1: 0,
        2: 0,
        3: 0,
        4: 0,
        5: 0,
        6: 0,
        7: 0,
        8: 0,
        31: 0,
        32: 0,
        33: 0,
        34: 0,
        35: 0,
        36: 0,
        37: 0,
        38: 0,
        39: 0,
      },
      sidoType: {
        1: 0,
        2: 1,
        3: 2,
        4: 3,
        5: 4,
        6: 5,
        7: 6,
        8: 7,
        31: 8,
        32: 9,
        33: 10,
        34: 11,
        35: 12,
        36: 13,
        37: 14,
        38: 15,
        39: 16,
      },
      win: 0,
      index: 0,
      winSido: "",
    };
  },
  created() {
    http
      .get(`map/chart`)
      .then((response) => {
        let logData = response.data;

        for (let i = 0; i < logData.length; ++i) {
          ++this.type[logData[i].sidoCode];
          if (this.type[logData[i].sidoCode] > this.win) {
            this.win = this.type[logData[i].sidoCode];
            this.index = logData[i].sidoCode;
          }
        }
      })
      .then(() => {
        this.chartData = {
          labels: [
            "서울",
            "인천",
            "대전",
            "대구",
            "광주",
            "부산",
            "울산",
            "세종",
            "경기도",
            "강원도",
            "충청북도",
            "충청남도",
            "경상북도",
            "경상남도",
            "전라북도",
            "전라남도",
            "제주도",
          ],
          datasets: [
            {
              label: "Count", // 그래프의 제목(값만 수정하면됨)
              backgroundColor: [
                // 색상 적당히 구성 됨.
                "rgba(255, 99, 132, 0.8)",
                "rgba(54, 162, 235, 0.8)",
                "rgba(255, 206, 86, 0.8)",
                "rgba(75, 192, 192, 0.8)",
                "rgba(153, 102, 255, 0.8)",
                "rgba(255, 159, 64, 0.8)",
                "rgba(255, 99, 132, 0.6)",
                "rgba(54, 162, 235, 0.6)",
                "rgba(255, 206, 86, 0.6)",
                "rgba(75, 192, 192, 0.6)",
                "rgba(153, 102, 255, 0.6)",
                "rgba(255, 159, 64, 0.6)",
                "rgba(255, 99, 132, 1.0)",
                "rgba(54, 162, 235, 1.0)",
                "rgba(255, 206, 86, 1.0)",
                "rgba(75, 192, 192, 1.0)",
                "rgba(153, 102, 255, 1.0)",
                "rgba(255, 159, 64, 1.0)",
              ],
              data: [
                this.type[1],
                this.type[2],
                this.type[3],
                this.type[4],
                this.type[5],
                this.type[6],
                this.type[7],
                this.type[8],
                this.type[31],
                this.type[32],
                this.type[33],
                this.type[34],
                this.type[35],
                this.type[36],
                this.type[37],
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
        this.winSido = this.chartData.labels[this.sidoType[this.index]];
      });
  },
  methods: {},
};
</script>

<style>
.chart-view__doughnut-sido {
  padding: 20px;
  position: relative;
}
.chart-view__doughnut-sido__text {
  position: absolute;
  width: 100px;
  height: 100px;
  left: 39%;
  top: 60%;
  color: var(--color-main);
}
</style>
