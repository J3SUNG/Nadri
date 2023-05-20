<template>
  <div class="plan">
    <h1 class="plan__title">여행 노트</h1>
    <div class="plan__write">
      <button class="plan__write-button">계획 생성</button>
    </div>
    <div class="plan__cards">
      <plan-card v-for="item in plans" :itemData="item" :key="item.planNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import PlanCard from "@/components/plan/PlanCard.vue";

export default {
  name: "PlanList",
  components: {
    PlanCard,
  },
  data() {
    return {
      plans: [],
    };
  },
  created() {
    http.get(`plan/list`).then((response) => {
      this.plans = response.data;
      console.log(response.data);
    });
  },
};
</script>

<style>
.plan {
  width: 100%;
  height: 100%;
}
.plan__write {
  text-align: right;
  margin-bottom: 20px;
  display: flex;
  justify-content: end;
  margin-right: 110px;
}
.plan__cards {
  margin-left: 75px;
  margin-right: 75px;
  display: flex;
  flex-wrap: wrap;
  justify-content: start;
}
.plan__write-button {
  display: flex;
  width: 110px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
</style>
