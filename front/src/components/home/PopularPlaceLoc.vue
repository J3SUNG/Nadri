<template>
  <div class="popular-place-loc">
    <div class="popular-place-loc__img__box">
      <img class="popular-place-loc__img" :src="this.items[0].img" />
    </div>
    <div class="popular-place-loc__box">
      <div class="popular-place-loc__text__box">
        <p class="line-through">ㅤㅤ</p>
        <p class="popular-place-loc__text__box__text">오늘의</p>
        <p class="popular-place-loc__text__box__sido">{{ this.items[0].sido }}</p>
        <p class="popular-place-loc__text__box__text">추천장소</p>
        <p class="line-through">ㅤㅤ</p>
      </div>
      <div class="popular-place-loc__icon__box">
        <img class="popular-place-loc__icon" :src="this.icons[this.items[0].type]" />
      </div>
      <div class="popular-place-loc__name__box">
        <h1 class="popular-place-loc__name">{{ this.items[0].name }}</h1>
      </div>
      <hr class="popular-place-loc__hr" />
      <div class="popular-place-loc__content__box">
        <p class="popular-place-loc__content">{{ this.items[0].content }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PopularPlaceLoc",
  data() {
    return {
      items: {
        0: {
          img: require("@/assets/dummy1.jpg"),
          sido: "서울",
          loc: "강남",
          type: "1", // 관광지, 문화시설, 행사, 여행코스, 레포츠, 숙박, 쇼핑, 음식점
          name: "강남 스시",
          content:
            "싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠 싱싱한 스시가! 냠냠",
        },
        1: {
          img: require("@/assets/dummy2.jpg"),
          sido: "대구",
          loc: "달서구",
          type: "0", // 관광지, 문화시설, 행사, 여행코스, 레포츠, 숙박, 쇼핑, 음식점
          name: "대구 막창",
          content:
            "쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠 쫄깃한 막창이! 냠냠",
        },
      },
      icons: {
        0: require("@/assets/bibimbap.png"),
        1: require("@/assets/birthday.png"),
      },
    };
  },
};
</script>

<style>
.popular-place-loc {
  width: 70%;
  height: 400px;
  position: relative;
}
.popular-place-loc__img {
  width: 100%;
  height: 100%;
  border-radius: 20px;
}
.popular-place-loc__img__box {
  width: 100%;
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
  color: var(--color-main);
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
  border: 2px solid var(--color-main);
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
</style>
