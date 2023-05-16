<template>
  <div class="plan">
    <h1 class="plan__title">계획 세우기</h1>
    <div class="plan__write">
      <button class="plan__write-button">계획 생성</button>
    </div>
    <div class="plan__cards">
      <plan-card v-for="item in plans" :itemData="item" :key="item.planNo" />
    </div>
  </div>
</template>

<script>
// import http from "@/util/http-common";
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
    // http.get(`board?type=${this.type}`).then((response) => {
    //   this.boards = response.data;
    // });
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
}
.plan__cards {
  display: flex;
  flex-wrap: wrap;
  margin-left: 50px;
  margin-right: 50px;
}
</style>
