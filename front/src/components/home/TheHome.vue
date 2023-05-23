<template>
  <div class="home">
    <div class="popular-place__box">
      <popular-place-loc />
      <popular-place-rank />
    </div>
    <div :class="{ home__component: true, 'home__the-thema__show': true }"><the-thema /></div>
    <div :class="{ home__component: true, 'home__popular-place-week__show': true }">
      <popular-place-week />
    </div>
    <div :class="{ home__component: true, 'home__popular-place-month__show': true }">
      <popular-place-month />
    </div>
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
  data() {
    return {
      popularPlaceMonthShow: false,
      lastScrollPosition: 0,
    };
  },
  // mounted() {
  //   window.addEventListener("scroll", this.onScroll);
  // },
  // beforeDestroy() {
  //   window.removeEventListener("scroll", this.onScroll);
  // },
  // methods: {
  // onScroll() {
  //   const currentScrollPosition = window.pageYOffset || document.documentElement.scrollTop;
  //   if (currentScrollPosition < 0) {
  //     this.popularPlaceMonthShow = false;
  //     return;
  //   }
  //   // Stop executing this function if the difference between
  //   // current scroll position and last scroll position is less than some offset
  //   if (Math.abs(currentScrollPosition - this.lastScrollPosition) < 280) {
  //     this.popularPlaceMonthShow = false;
  //     return;
  //   }
  //   this.popularPlaceMonthShow = true;
  // },
  // },
};
</script>

<style>
.popular-place__box {
  margin-top: 40px;
  display: flex;
}
.home__component {
  opacity: 0;
}
.home__the-thema__show {
  animation: fadeInUp 1s;
  animation-delay: 0s;
  animation-fill-mode: forwards;
}
.home__popular-place-week__show {
  animation: fadeInUp 1s;
  animation-delay: 0.3s;
  animation-fill-mode: forwards;
}
.home__popular-place-month__show {
  animation: fadeInUp 1s;
  animation-delay: 0.6s;
  animation-fill-mode: forwards;
}
@keyframes fadeInUp {
  0% {
    opacity: 0;
    transform: translate3d(0, 10%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}
</style>
