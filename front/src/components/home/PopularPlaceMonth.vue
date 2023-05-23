<template>
  <div class="popular-place-month">
    <div class="popular-place-month__main__visited">
      <h2 class="popular-place-month__main__visited__title">월간 인기 관광지</h2>
      <div class="popular-place-month__visited__slideShow">
        <ul class="popular-place-month__visited__slides" :style="`left:${this.left}`">
          <li v-for="item in places" :key="item.placeNo"><place-card :itemData="item" /></li>
        </ul>
        <p class="popular-place-month__visited__controller">
          <img
            src="@/assets/next.png"
            class="popular-place-month__visited__prev"
            @click="moveLeft"
          />
          <img
            src="@/assets/next.png"
            class="popular-place-month__visited__next"
            @click="moveRight"
          />
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import PlaceCard from "./PlaceCard.vue";
import http from "@/util/http-common";
export default {
  name: "PopularPlaceMonth",
  created() {
    http.get("attractionlike/monthly").then((response) => {
      this.places = response.data;
      console.log(response);
    });
  },
  data() {
    return {
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 8, // 슬라이드 개수

      places: "",
    };
  },
  methods: {
    moveUserUpdate() {
      this.$router.push({ name: "AppUserUpdate" });
    },
    //
    moveSlide(num) {
      this.left = -num * 370 + "px";
      this.currentIdx = num;
    },
    moveLeft() {
      if (this.currentIdx !== 0) this.moveSlide(this.currentIdx - 1);
    },
    moveRight() {
      if (this.currentIdx !== this.slideCount - 1) {
        this.moveSlide(this.currentIdx + 1);
      }
    },
  },
  components: {
    PlaceCard,
  },
};
</script>

<style>
.popular-place-month__main__visited {
  /* opacity: 0;
  animation: fadeInUp 0.5s;
  animation-delay: 0.5s;
  animation-fill-mode: forwards; */
}
.popular-place-month__main__visited__title {
  text-align: left;
  margin-bottom: 10px;
  margin-left: 20px;
  color: var(--color-black);
}
.popular-place-month__main__visited .popular-place-month__card {
  margin: 10px 0 0 0;
  padding: 0px;
}
@keyframes fadeInUp {
  from {
    transform: translate(0, 0);
  }
  to {
    transform: translate(100px, 100px);
  }
}
/* slide */
.popular-place-month__visited__slideShow {
  width: 100%;
  height: 400px;
  position: relative;
  overflow: hidden;
}
.popular-place-month__visited__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 2000px;
  transition: left 0.3s ease-out;
}
.popular-place-month__visited__slides .place__card {
  margin: 10px 30px 0 0px;
}
.popular-place-month__visited__slides li:first-child {
  margin-left: 30px;
}
.popular-place-month__visited__slides li:child {
  margin-right: 25px;
}
.popular-place-month__visited__slides li:not(:child) {
  float: left;
  margin-right: 20px;
}
.popular-place-month__visited__slides li {
  float: left;
}
.popular-place-month__visited__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  top: 50%;
  cursor: pointer;
}
.popular-place-month__visited__prev {
  width: 40px;
  height: 40px;
  left: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
}
.popular-place-month__visited__prev:hover {
  backdrop-filter: brightness(70%);
}
.popular-place-month__visited__next {
  width: 40px;
  height: 40px;
  right: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
  transform: rotate(180deg);
}
.popular-place-month__visited__next:hover {
  backdrop-filter: brightness(70%);
  transform: rotate(180deg);
}
</style>
