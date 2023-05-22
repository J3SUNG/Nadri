<template>
  <div class="home">
    <div class="popular-place__box">
      <popular-place-loc />
      <popular-place-rank />
    </div>
    <the-thema/>
    <div class="popular-board"></div>
  </div>
</template>

<script>
import PopularPlaceLoc from "./PopularPlaceLoc.vue";
import PopularPlaceRank from "./PopularPlaceRank.vue";
import TheThema from "./TheThema.vue";
export default {
  components: { PopularPlaceLoc, PopularPlaceRank, TheThema},
  name: "TheHome",
};
</script>

<style>
.popular-place__box {
  display: flex;
}
</style>
