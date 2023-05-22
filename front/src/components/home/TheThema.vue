<template>
    <div class="thema">
      <ul class="thema__icon__box">
        <li class="thema__icon__box-small" v-for="(item, index) in themaIcon" :key="index">
          <img class="thema__icon__box-img" :src="item.img"/>
          <p class="thema__icon__box-text">{{item.name}}</p>
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
            img: require("@/assets/bibimbap.png"),
            name: "전체",
          },
          1: {
            img: require("@/assets/bibimbap.png"),
            name: "관광지",
          },
          2: {
            img: require("@/assets/bibimbap.png"),
            name: "문화시설",
          },
          3: {
            img: require("@/assets/bibimbap.png"),
            name: "축제",
          },
          4: {
            img: require("@/assets/birthday.png"),
            name: "여행코스",
          },
          5: {
            img: require("@/assets/birthday.png"),
            name: "레포츠",
          },
          6: {
            img: require("@/assets/birthday.png"),
            name: "숙박",
          },
          7: {
            img: require("@/assets/birthday.png"),
            name: "쇼핑",
          },
          8: {
            img: require("@/assets/birthday.png"),
            name: "음식점",
          },
        }
      }
    }
  };
  </script>
  
  <style>
  .thema{
    margin-top: 50px;
    width: 100%;
    height:160px;
    background-color: var(--color-week2);
    border-radius: 10px;
  }
  .thema__icon__box{
    height: 100%;
    width: calc(100%-40px);
    margin: 0px 20px;
    display: flex;
    justify-content: space-between;
  }
  .thema__icon__box-small {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }
  .thema__icon__box-img {
    width: 80px;
    height: 80px;
  }
  .thema__icon__box-text {
    color: var(--color-black);
    font-size: 22px;
  }
  </style>
  