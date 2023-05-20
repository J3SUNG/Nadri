<template>
  <div class="plan">
    <div class="plan__header">
      <plan-best></plan-best>
      <plan-like></plan-like>
    </div>
    <div class="plan__main">
      <plan-list></plan-list>
    </div>
  </div>
</template>

<script>
import PlanBest from "@/components/plan/PlanBest.vue";
import PlanLike from "@/components/plan/PlanLike.vue";
import PlanList from "@/components/plan/PlanList.vue";

export default {
  name: "AppPlan",
  components: { PlanList, PlanBest, PlanLike },
};
</script>

<style>
.plan {
  display: flex;
  width: 100%;
  flex-direction: column;
}
.plan__header {
  margin-top: 40px;
  display: flex;
}
</style>
