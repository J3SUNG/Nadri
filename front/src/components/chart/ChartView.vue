<template>
  <div class="chart-view">
    <h2 class="chart-view__title">최근 인기 관광지 5개의 차트</h2>
    <Liness :chart-data="bests" v-if="loaded"></Liness>
    <PieChart></PieChart>
  </div>
</template>

<script>
// import BarChart from "@/components/chart/Bar2.vue";
import Liness from "@/components/chart/Line.vue";
import PieChart from "@/components/chart/PieChart.vue";
import http from "@/util/http-common";

export default {
  name: "ChartView",
  components: {
    PieChart,
    Liness,
  },
  data() {
    return {
      loaded: false,
      bests: {
        labels: ["6월1일", "6월2일", "6월3일", "6월4일", "6월5일", "6월6일", "6월7일"],
        datasets: [
          {
            label: "",
            data: [],
            borderColor: "#f87979", //라인색
            backgroundColor: "#f87979", //"#f87979", //점 색
            pointStyle: "circle", //모양 //rectRounded
            pointRadius: 10, // 기본 기본 크기
            pointHoverRadius: 20, //마우스 hover시 커지는
            //borderDash: [5, 5],
          },
          {
            label: "",
            data: [],
            borderColor: "#41B883", //라인색
            backgroundColor: "#41B883", //"#f87979", //점 색
            pointStyle: "rect", //모양 //rectRounded
            pointRadius: 10, // 기본 기본 크기
            pointHoverRadius: 20, //마우스 hover시 커지는
            borderDash: [5, 5],
          },
          {
            label: "",
            data: [],
            borderColor: "#E46651", //라인색
            backgroundColor: "#E46651", //"#f87979", //점 색
            pointStyle: "star", //모양 //rectRounded
            pointRadius: 10, // 기본 기본 크기
            pointHoverRadius: 20, //마우스 hover시 커지는
            //borderDash: [5, 5],
          },
          {
            label: "",
            data: [],
            borderColor: "#00D8FF", //라인색
            backgroundColor: "#00D8FF", //"#f87979", //점 색
            pointStyle: "rectRounded", //모양 //rectRounded
            pointRadius: 10, // 기본 기본 크기
            pointHoverRadius: 20, //마우스 hover시 커지는
            borderDash: [10, 10],
          },
          {
            label: "",
            data: [],
            borderColor: "#DD1B16", //라인색
            backgroundColor: "#DD1B16", //"#f87979", //점 색
            pointStyle: "triangle", //모양 //rectRounded
            pointRadius: 10, // 기본 기본 크기
            pointHoverRadius: 20, //마우스 hover시 커지는
            borderDash: [15, 15],
          },
        ],
      },
    };
  },
  async mounted() {
    let days = [];
    for (let i = 0; i < 7; i++) {
      await http.get(`attractionlike/day/2023-06-0${i + 1}`).then(({ data }) => days.push(data));

      console.log(days[i]);
    }
    console.log("time");
    console.log(days[0][0]);
    for (let j = 0; j < 5; j++) {
      this.bests.datasets[j].label = days[0][j].title;
      this.bests.datasets[j].data.push(days[0][j].cnt);
    }
    for (let i = 1; i < 7; i++) {
      for (let j = 0; j < 5; j++) {
        this.bests.datasets[j].data.push(days[i][j].cnt);
      }
    }
    this.loaded = true;
  },
  methods: {},
};
</script>

<style>
.chart-view__title {
  color: var(--color-black);
  margin-bottom: 20px;
}
</style>
