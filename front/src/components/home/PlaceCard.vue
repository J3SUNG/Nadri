<template>
  <div class="place__card" @click="movePlaceDetail">
    <img class="place__card__img" :src="itemData.image1" />
    <h3 class="place__card__subject">{{ itemData.title }}</h3>
    <p class="place__card__addr">
      {{ itemData.addr1 }}
    </p>
    <hr class="place__card__hr" />
    <p class="place__card__overview">
      {{ itemData.overview }}
    </p>
  </div>
</template>

<script>
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "PlaceCard",
  data() {
    return {};
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  props: ["itemData"],
  methods: {
    movePlaceDetail() {
      // if (!(event.target.classList[1] === "place__card__footer__icon-heart")) {
      //   this.$router.push({ name: "AppPlaceDetail", params: { planNo: this.itemData.planNo } });
      // }
    },
  },
};
</script>

<style>
.place__card {
  width: 340px;
  height: 340px;
  border: 0px solid var(--color-black);
  margin-bottom: 40px;
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: var(--color-white);
  transition: all 0.1s linear;
  font-size: 16px;
  text-align: left;
  cursor: pointer;
}
.place__card:hover {
  transform: scale(1.04);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.place__card__img {
  width: 320px;
  height: 200px;
  margin: 10px;
  /* overflow: hidden; */
}
.place__card__subject {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.place__card__addr {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-top: 10px;
}
.place__card__overview {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.place__card__hr {
  width: 90%;
  margin: 10px;
}
</style>
