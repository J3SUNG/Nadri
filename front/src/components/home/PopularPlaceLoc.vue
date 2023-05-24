<template>
  <div class="popular-place-loc">
    <div class="popular-place-loc__slideShow">
      <ul class="popular-place-loc__slides" :style="`left:${left}`">
        <li
          class="popular-place-loc__li"
          v-for="(item, index) in items"
          :key="item.attractionNo"
          @click="movePlaceDetail(index)"
        >
          <!--  -->
          <div class="popular-place-loc__img__box">
            <img class="popular-place-loc__img" :src="`${item.image1}`" />
          </div>
          <div class="popular-place-loc__box" :style="`left:${section * index}px`">
            <div class="popular-place-loc__box__section">
              <div class="popular-place-loc__text__box">
                <p class="line-through">ㅤㅤ</p>
                <p class="popular-place-loc__text__box__text">오늘의</p>
                <p class="popular-place-loc__text__box__sido">{{ sido[item.sidoCode] }}</p>
                <p class="popular-place-loc__text__box__text">추천장소</p>
                <p class="line-through">ㅤㅤ</p>
              </div>
              <div class="popular-place-loc__icon__box">
                <img class="popular-place-loc__icon" :src="`${icons[item.contentType]}`" />
              </div>
              <div class="popular-place-loc__name__box">
                <h2 class="popular-place-loc__name">{{ item.title }}</h2>
              </div>
              <hr class="popular-place-loc__hr" />
              <div class="popular-place-loc__content__box">
                <p class="popular-place-loc__content">{{ item.overview }}</p>
              </div>
            </div>
          </div>
          <!--  -->
        </li>
      </ul>
      <p class="popular-place-loc__controller">
        <img src="@/assets/next.png" class="popular-place-loc__prev" @click="moveLeft" />
        <img src="@/assets/next.png" class="popular-place-loc__next" @click="moveRight" />
      </p>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "PopularPlaceLoc",
  data() {
    return {
      section: 800,
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 17, // 슬라이드 개수
      items: "",
      icons: {
        12: require("@/assets/type/type_trip.png"),
        14: require("@/assets/type/type_cultural.png"),
        15: require("@/assets/type/type_event.png"),
        25: require("@/assets/type/type_course.png"),
        28: require("@/assets/type/type_leport.png"),
        32: require("@/assets/type/type_home.png"),
        38: require("@/assets/type/type_shopping.png"),
        39: require("@/assets/type/type_food.png"),
      },
      sido: {
        1: "서울",
        2: "인천",
        3: "대전",
        4: "대구",
        5: "광주",
        6: "부산",
        7: "울산",
        8: "세종",
        31: "경기도",
        32: "강원도",
        33: "충청북도",
        34: "충청남도",
        35: "경상북도",
        36: "경상남도",
        37: "전라북도",
        38: "전라남도",
        39: "제주도",
      },
    };
  },
  created() {
    http.get("attractionlike/sido").then((response) => {
      this.items = response.data;
    });
  },
  methods: {
    moveSlide(num) {
      this.left = -num * 800 + "px";
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
    timerStart() {
      // 1초에 한번씩 start 호출
      this.TimeCounter = 180;
      var interval = setInterval(() => {
        if (this.currentIdx === this.slideCount - 1) {
          this.currentIdx = -1;
          this.left = 0;
        }
        this.moveRight();
      }, 3000);
      return interval;
    },
    movePlaceDetail(index) {
      this.$router.push({
        name: "AppMap",
        params: {
          search: `${this.items[index].title}`,
          attractionNo: `${this.items[index].attractionNo}`,
        },
      });
    },
  },
  mounted() {
    this.timerStart();
  },
};
</script>

<style>
.popular-place-loc {
  width: 70%;
  height: 400px;
  position: relative;
}
.popular-place-loc__li {
  width: 100%;
  cursor: pointer;
}
.popular-place-loc__img {
  width: 100%;
  height: 100%;
  border-radius: 20px;
}
.popular-place-loc__img__box {
  width: 800px;
  height: 100%;
}
.popular-place-loc__box {
  border-radius: 20px;
  position: absolute;
  backdrop-filter: brightness(50%);
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.popular-place-loc__box__section {
  position: absolute;
  left: 0px;
  width: 800px;
}
.popular-place-loc__text__box {
  margin-top: 60px;
}
.popular-place-loc__text__box__text {
  display: inline-block;
  color: var(--color-white);
  margin: 0px 10px;
}
.popular-place-loc__text__box__sido {
  display: inline-block;
  color: var(--color-week);
  font-size: 24px;
}
.popular-place-loc__icon__box {
  margin-top: 20px;
}
.popular-place-loc__icon {
  width: 100px;
  height: 100px;
}
.popular-place-loc__name__box {
  margin-top: 10px;
}
.popular-place-loc__name {
  color: var(--color-white);
}
.popular-place-loc__hr {
  margin-top: 10px;
  margin-left: 48.5%;
  width: 3%;
  border: 2px solid var(--color-week);
}
.popular-place-loc__content__box {
  margin-top: 20px;
}
.popular-place-loc__content {
  color: var(--color-white);
  margin-left: 5%;
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.line-through {
  text-decoration: line-through;
  display: inline-block;
  color: var(--color-lightgray);
}
/* slide */
.popular-place-loc__slideShow {
  width: 800px;
  height: 400px;
  border-radius: 20px;
  position: relative;
  overflow: hidden;
}
.popular-place-loc__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 800px;
  transition: left 0.3s ease-out;
}
.popular-place-loc__slides li:first-child {
  margin-left: 0px;
}
.popular-place-loc__slides li:last-child {
  margin-right: 0px;
}
.popular-place-loc__slides li:not(:last-child) {
  float: left;
  margin-right: 0px;
}
.popular-place-loc__slides li {
  float: left;
}
.popular-place-loc__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  cursor: pointer;
  top: 10px;
  border-radius: 20px;
}
.popular-place-loc__prev {
  width: 40px;
  height: 40px;
  right: 52px;
  backdrop-filter: brightness(200%);
}
.popular-place-loc__prev:hover {
  backdrop-filter: brightness(300%);
}
.popular-place-loc__next {
  width: 40px;
  height: 40px;
  right: 10px;
  backdrop-filter: brightness(200%);

  transform: rotate(180deg);
}
.popular-place-loc__next:hover {
  backdrop-filter: brightness(300%);
  transform: rotate(180deg);
}
</style>
