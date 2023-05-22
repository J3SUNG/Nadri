<template>
  <div class="home">
    <div class="popular-place__box">
      <popular-place-loc />
      <popular-place-rank />
    </div>
    <the-thema />
    <popular-place-week />
    <popular-place-month />
  </div>
</template>

<script>
import PopularPlaceWeek from "./PopularPlaceWeek.vue";
import PopularPlaceLoc from "./PopularPlaceLoc.vue";
import PopularPlaceRank from "./PopularPlaceRank.vue";
import TheThema from "./TheThema.vue";
import PopularPlaceMonth from "./PopularPlaceMonth.vue";
export default {
  components: { PopularPlaceLoc, PopularPlaceRank, TheThema, PopularPlaceWeek, PopularPlaceMonth },
  name: "TheHome",
};
</script>

<style>
.popular-place__box {
  margin-top: 40px;
  display: flex;
}
</style>
