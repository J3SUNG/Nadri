<template>
  <div class="thema">
    <ul class="thema__icon__box">
      <li class="thema__icon__box-small" v-for="(item, index) in themaIcon" :key="index">
        <img class="thema__icon__box-img" :src="item.img" />
        <p class="thema__icon__box-text">{{ item.name }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "TheThema",
  data() {
    return {
      themaIcon: {
        0: {
          img: require("@/assets/type_color/type_color_all.png"),
          name: "전체",
        },
        1: {
          img: require("@/assets/type_color/type_color_trip.png"),
          name: "관광지",
        },
        2: {
          img: require("@/assets/type_color/type_color_cultural.png"),
          name: "문화시설",
        },
        3: {
          img: require("@/assets/type_color/type_color_event.png"),
          name: "축제",
        },
        4: {
          img: require("@/assets/type_color/type_color_course.png"),
          name: "여행코스",
        },
        5: {
          img: require("@/assets/type_color/type_color_leport.png"),
          name: "레포츠",
        },
        6: {
          img: require("@/assets/type_color/type_color_home.png"),
          name: "숙박",
        },
        7: {
          img: require("@/assets/type_color/type_color_shopping.png"),
          name: "쇼핑",
        },
        8: {
          img: require("@/assets/type_color/type_color_food.png"),
          name: "음식점",
        },
      },
    };
  },
};
</script>

<style>
.thema {
  margin-top: 50px;
  margin-bottom: 50px;
  width: 100%;
  height: 160px;
  background-color: var(--color-week2);
  border-radius: 10px;
}
.thema__icon__box {
  height: 100%;
  width: calc(100%-40px);
  margin: 0px 30px;
  display: flex;
  justify-content: space-between;
}
.thema__icon__box-small {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  cursor: pointer;
}
.thema__icon__box-small:hover {
  animation: moveUp 1s;
}
@keyframes moveUp {
  0% {
    transform: translateZ(0);
  }
  to {
    transform: translate3d(0, -5%, 0);
  }
}
.thema__icon__box-img {
  width: 60px;
  height: 60px;
}
.thema__icon__box-text {
  color: var(--color-black);
  font-size: 22px;
}
</style>
