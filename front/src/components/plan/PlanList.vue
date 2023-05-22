<template>
  <div class="plan-note">
    <div class="plan-note__header">
      <h2 class="plan-note__title">여행노트</h2>
      <button class="plan-note__write-button" @click="movePlanCreate">글쓰기</button>
    </div>
    <div class="plan-note__cards">
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
      userNo: 0,
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    http.get(`plan/list/${this.userNo}`).then((response) => {
      this.plans = response.data;
      console.log(response.data);
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
.plan-note {
  width: 100%;
  height: 100%;
  padding: 50px 0px;
}
.plan-note__header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 0px 0px 0 10px;
}
.plan-note__cards {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
.plan-note__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
</style>
