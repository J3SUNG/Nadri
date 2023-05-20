<template>
  <div class="plan">
    <h1 class="plan__title">여행노트</h1>
    <div class="plan__write">
      <button class="plan__write-button" @click="movePlanCreate">글쓰기</button>
    </div>
    <div class="plan__cards">
      <plan-card v-for="item in plans" :itemData="item" :key="item.planNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import PlanCard from "./PlanCard.vue";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "PlanList",
  components: {
    PlanCard,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      plans: [],
      type: "1",
    };
  },
  created() {
    http.get(`plan/list/${this.userInfo.userNo}`).then((response) => {
      this.plans = response.data;
      console.log(this.plans);
    });
  },
  methods: {
    movePlanCreate() {
      this.$router.push({ name: "AppPlanCreate" });
    },
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
  width: 100%;
  margin-left: 75px;
  margin-right: 75px;
  display: flex;
  flex-wrap: wrap;
  justify-content: start;
}
.plan__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
</style>
