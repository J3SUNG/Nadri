<template>
  <div class="news-info">
    <h2 class="news-info__title">국내여행 소식</h2>
    <div class="news-info__loading__box" v-if="loading">
      <div class="news-info__visited__slideShow">
        <ul class="news-info__visited__slides" :style="`left:${this.left}`">
          <li class="news-info__box" v-for="(item, index) in newsList" :key="index">
            <a class="news-info__box__a-box" :href="item.url">
              <img class="news-info__box__a-box__img" :src="item.img" />
              <p class="news-info__box__a-box__p">{{ item.title }}</p>
            </a>
          </li>
        </ul>
        <p class="news-info__visited__controller">
          <img src="@/assets/next.png" class="news-info__visited__prev" @click="moveLeft" />
          <img src="@/assets/next.png" class="news-info__visited__next" @click="moveRight" />
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import cheerio from "cheerio";
export default {
  name: "NewsInfo",
  data() {
    return {
      newsList: [],

      list: [],
      url: "https://www.joongang.co.kr/travel/domestic",
      title: "Hi",
      loading: false,
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 22, // 슬라이드 개수
    };
  },
  mounted() {
    const getHtml = async () => {
      const html = await axios.get(this.url);
      const $ = cheerio.load(html.data);
      const bodyList = $("#container > section > section > div.photo_list_area > ul > li");
      bodyList.map((i, element) => {
        var news = {
          title: "",
          img: "",
          url: ",",
        };

        news["title"] = $(element).find("h2.headline a").text();
        news["img"] = $(element).find("figure.card_image img").attr("src");
        news["url"] = $(element).find("figure.card_image a").attr("href");

        this.newsList[i] = news;
        this.loading = true;
      });
    };
    getHtml();
  },
  methods: {
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
};
</script>

<style>
.news-info {
  text-align: left;
  width: 100%;
  height: 400px;
  overflow: hidden;
}
.news-info__title {
  color: var(--color-black);
}
.news-info__box {
  display: flex;
  justify-content: space-around;
  width: 100%;
  height: 300px;
  margin-top: 10px;
}
.news-info__box__a-box {
  width: 340px;
  margin-right: 30px;
}
.news-info__box__a-box:hover {
  transform: scale(1.04);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.news-info__box__a-box__img {
  padding: 10px;
  width: 320px;
  height: 200px;
}
.news-info__box__a-box__p {
  padding: 10px;
  color: var(--color-black);
}
/* slide */
.news-info__visited__slideShow {
  width: 100%;
  height: 400px;
  position: relative;
  overflow: hidden;
}
.news-info__visited__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 2000px;
  transition: left 0.3s ease-out;
}
.news-info__visited__slides .news-info__card {
  margin: 10px 30px 0 0px;
}
.news-info__visited__slides li:first-child {
  margin-left: 30px;
}
.news-info__visited__slides li:child {
  margin-right: 25px;
}
.news-info__visited__slides li:not(:child) {
  float: left;
  margin-right: 20px;
}
.news-info__visited__slides li {
  float: left;
}
.news-info__visited__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  top: 50%;
  cursor: pointer;
}
.news-info__visited__prev {
  width: 40px;
  height: 40px;
  left: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
}
.news-info__visited__prev:hover {
  backdrop-filter: brightness(70%);
}
.news-info__visited__next {
  width: 40px;
  height: 40px;
  right: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
  transform: rotate(180deg);
}
.news-info__visited__next:hover {
  backdrop-filter: brightness(70%);
  transform: rotate(180deg);
}
</style>
