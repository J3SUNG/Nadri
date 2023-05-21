<template>
  <div class="home">
    <div class="popular-place__box">
      <popular-place-loc />
      <popular-place-rank />
    </div>
    <div class="thema"></div>
    <div class="popular-board"></div>
  </div>
</template>

<script>
import PopularPlaceLoc from "./PopularPlaceLoc.vue";
import PopularPlaceRank from "./PopularPlaceRank.vue";
export default {
  components: { PopularPlaceLoc, PopularPlaceRank },
  name: "TheHome",
};
</script>

<style>
.popular-place__box {
  display: flex;
}
</style>
