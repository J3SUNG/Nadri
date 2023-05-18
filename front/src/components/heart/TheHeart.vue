<template>
  <div class="heart">
    <img class="heart-icon" @click="heartClick" :src="heart" />
    <p class="heart-text">{{ heartCnt }}</p>
  </div>
</template>

<script>
export default {
  name: "TheHeart",
  props: {
    heartCnt: Number,
  },
  data() {
    return {
      heart: require("@/assets/heartOff.png"),
      heartChk: false,
    };
  },
  methods: {
    heartClick() {
      console.log(this.heartCnt);
      this.heartChk = !this.heartChk;
      if (!this.heartChk) {
        this.heart = require("@/assets/heartOff.png");
      } else {
        this.heart = require("@/assets/heartOn.png");
      }
    },
  },
};
</script>

<style>
.heart {
  display: flex;
  justify-content: end;
  align-content: center;
}
.heart-icon {
  margin-left: 5px;
  width: 18px;
  height: 18px;
}
.heart-icon:hover {
  animation: scaling 1s ease-in-out infinite;
}
@keyframes scaling {
  from {
    transform: scale(1.3);
  }
  to {
    transform: scale(1);
  }
}
</style>
