<template>
  <div class="popular-place-rank">
    <h3 class="popular-place-rank__title">오늘의 인기 장소</h3>
    <hr class="popular-place-rank__hr" />
    <ol ckass="popular-place-rank__loc__box" @mouseover="rankOver">
      <li class="popular-place-rank__loc" v-for="(item, index) in popularPlace" :key="item.attrNo">
        <p class="popular-place-rank__loc-rank">{{ index }}위</p>
        <p class="popular-place-rank__loc-rank">{{ item.name }}</p>
      </li>
    </ol>
  </div>
</template>

<script>
export default {
  name: "PopularPlaceRank",
  data() {
    return {
      popularPlace: {
        0: {
          img: require("@/assets/dummy1.jpg"),
          name: "서울역 카페",
          attrNo: "1",
        },
        1: {
          img: require("@/assets/dummy2.jpg"),
          name: "구미역 식당",
          attrNo: "2",
        },
        2: {
          img: require("@/assets/dummy3.jpg"),
          name: "대구역 클라이밍",
          attrNo: "3",
        },
        3: {
          img: require("@/assets/dummy4.jpg"),
          name: "인천 해수욕장",
          attrNo: "4",
        },
        4: {
          img: require("@/assets/dummy5.jpg"),
          name: "부산 숙소",
          attrNo: "5",
        },
        5: {
          img: require("@/assets/dummy6.jpg"),
          name: "광주 카페",
          attrNo: "6",
        },
        6: {
          img: require("@/assets/dummy1.jpg"),
          name: "대전 식당",
          attrNo: "7",
        },
        7: {
          img: require("@/assets/dummy2.jpg"),
          name: "경주 클라이밍",
          attrNo: "8",
        },
        8: {
          img: require("@/assets/dummy3.jpg"),
          name: "안동 해수욕장",
          attrNo: "9",
        },
        9: {
          img: require("@/assets/dummy4.jpg"),
          name: "제주도 숙소",
          attrNo: "10",
        },
      },
    };
  },
  methods: {
    rankOver(event) {
      console.log(event);
    },
  },
};
</script>

<style>
.popular-place-rank {
  width: 27%;
  margin-left: 3%;
  height: calc(400px-40px);
  border: 3px solid var(--color-week);
  border-radius: 10px;
  padding: 20px;
}
.popular-place-rank {
  text-align: left;
}
.popular-place-rank__hr {
  margin: 5px 0px;
}
.popular-place-rank__title {
  text-align: center;
  color: var(--color-main);
}
.popular-place-rank__loc__box {
  width: 100%;
}
.popular-place-rank__loc:nth-child(1) {
  background-color: #FF6701;
}
.popular-place-rank__loc:nth-child(1) p {
  color: var(--color-white);
}
.popular-place-rank__loc:nth-child(2) {
  background-color: #FEA82F;
}
.popular-place-rank__loc:nth-child(2) p {
  color: var(--color-white);
}
.popular-place-rank__loc:nth-child(3) {
  background-color: #ffad5f;
}
.popular-place-rank__loc:nth-child(3) p {
  color: var(--color-white);
}
.popular-place-rank__loc {
  background-color: #ffbc82;
  width: 100%;
  height: 30px;
  transition: all ease 0.3s 0s;
  cursor: pointer;
  border-radius: 5px;
  margin: 1px;
  
}
.popular-place-rank__loc p{
  color: var(--color-white);
}
.popular-place-rank__loc:hover {
  width: 100%;
  height: 30px;
  opacity: 0.8;
  border-bottom: 1px dotted var(--color-lightgray);
}

.popular-place-rank__loc-rank {
  display: inline-block;
  margin-left: 20px;
}
.popular-place-rank__loc-text {
  display: inline-block;
}
</style>
