<template>
  <div class="popular-place-rank">
    <h3 class="popular-place-rank__title">오늘의 인기 장소</h3>
    <hr class="popular-place-rank__hr" />
    <ol ckass="popular-place-rank__loc__box">
      <li
        class="popular-place-rank__loc"
        v-for="(item, index) in popularPlace"
        :key="item.attrNo"
        @click="movePlaceDetail(index)"
      >
        <p class="popular-place-rank__loc-rank popular-place-rank__loc-rank__nth">
          {{ index * 1 + 1 }}위
        </p>
        <p class="popular-place-rank__loc-rank__title">{{ item.title }}</p>
      </li>
    </ol>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "PopularPlaceRank",
  data() {
    return {
      popularPlace: "",
    };
  },
  created() {
    http.get("attractionlike/daily").then((response) => {
      this.popularPlace = response.data;
      console.log(response);
    });
  },
  methods: {
    movePlaceDetail(index) {
      this.$router.push({
        name: "AppMap",
        params: {
          search: `${this.popularPlace[index].title}`,
          attractionNo: `${this.popularPlace[index].attractionNo}`,
        },
      });
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
  color: var(--color-tomato);
  font-size: 24px;
}
.popular-place-rank__loc__box {
  width: 100%;
}
.popular-place-rank__loc:nth-child(1) {
  background-color: #ff6701;
  animation: fadeInUpUp 1s;
  animation-delay: 0s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(1) p {
  color: var(--color-white);
}
.popular-place-rank__loc:nth-child(2) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.1s;
  animation-fill-mode: forwards;
  background-color: #fea82f;
}
.popular-place-rank__loc:nth-child(2) p {
  color: var(--color-white);
}
.popular-place-rank__loc:nth-child(3) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.2s;
  animation-fill-mode: forwards;
  background-color: #ffad5f;
}
.popular-place-rank__loc:nth-child(3) p {
  color: var(--color-white);
}
.popular-place-rank__loc:nth-child(4) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.3s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(5) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.4s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(6) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.5s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(7) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.6s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(8) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.7s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(9) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.8s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc:nth-child(10) {
  animation: fadeInUpUp 1s;
  animation-delay: 0.9s;
  animation-fill-mode: forwards;
}
.popular-place-rank__loc {
  background-color: #ffbc82;
  width: 100%;
  height: 30px;
  transition: all ease 0.3s 0s;
  cursor: pointer;
  border-radius: 5px;
  margin: 1px;
  display: flex;
  align-items: center;
  opacity: 0;
}
.popular-place-rank__loc-rank__nth {
  width: 40px;
  text-align: center;
}
.popular-place-rank__loc-rank__title {
  width: 160px;
  text-align: left;

  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.popular-place-rank__loc p {
  color: var(--color-white);
}
.popular-place-rank__loc:hover {
  opacity: 0.8;
}

.popular-place-rank__loc-rank {
  display: inline-block;
  margin: 0px 20px;
}
.popular-place-rank__loc-text {
  display: inline-block;
}
</style>
