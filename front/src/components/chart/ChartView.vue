<template>
  <div class="chart-view">
    <div class="chart-view__box-up">
      <div class="chart-view__pie-type__box">
        <h3 class="chart-view__pie-type__title">타입 별 방문자 비율</h3>
        <PieChartType></PieChartType>
      </div>
      <div class="chart-view__pie-sido__box">
        <h3 class="chart-view__pie-sido__title">시도 별 방문자 비율</h3>
        <DoughnutChartSido></DoughnutChartSido>
      </div>
    </div>
    <div class="chart-view__bar__box">
      <h3 class="chart-view__bar__title">방문자 수 순위</h3>
      <bar-chart></bar-chart>
    </div>
  </div>
</template>

<script>
import PieChartType from "@/components/chart/PieChartType.vue";
import DoughnutChartSido from "@/components/chart/DoughnutChartSido.vue";
import BarChart from "./BarChart.vue";

export default {
  name: "ChartView",
  components: {
    PieChartType,
    DoughnutChartSido,
    BarChart,
  },
  data() {
    return {};
  },
  async mounted() {},
  methods: {},
};
</script>

<style>
.chart-view__box-up {
  display: flex;
}
.chart-view__title {
  color: var(--color-black);
  margin-bottom: 20px;
}
.chart-view__pie-type__box {
  padding: 0 0 0 10%;
  width: 40%;
}
.chart-view__pie-sido__box {
  padding: 0 10% 0 0;
  width: 40%;
}
.chart-view__bar__box {
  padding-top: 50px;
  width: 100%;
}
</style>
