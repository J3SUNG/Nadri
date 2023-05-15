<template>
  <div class="logo" @click="logoClick">
    <img class="logo__img" alt="page logo" :src="img" />
    <div class="logo__right">
      <h3 class="logo__text">놀러</h3>
      <h3 class="logo__text logo__text__flounder">가자미</h3>
    </div>
  </div>
</template>

<script>
export default {
  name: "TheLogo",
  data() {
    return {
      img: require("@/assets/logo_waterfall.png"),
      imgList: [
        require("@/assets/logo_beach.png"),
        require("@/assets/logo_street.png"),
        require("@/assets/logo_aurora.png"),
        require("@/assets/logo_mountains.png"),
        require("@/assets/logo_desert.png"),
        require("@/assets/logo_waterfall.png"),
      ],
      num: 0,
    };
  },
  methods: {
    logoClick() {
      if (this.$route.path !== "/") {
        this.$router.push({ name: "AppHome" });
      }
    },
    hello() {
      this.img = this.imgList[this.num];
      ++this.num;
      if (this.num >= this.imgList.length) {
        this.num = 0;
      }
    },
  },
  mounted() {
    this.interval = setInterval(this.hello, 2000);
  },
};
</script>

<style>
.logo {
  display: flex;
  align-items: center;
}
.logo:hover {
  cursor: pointer;
}
.logo__img {
  width: 50px;
  height: 50px;
  animation: slippery 1s linear 0s infinite alternate;
}
@keyframes slippery {
  0% {
    opacity: 0.6;
  }
  100% {
    opacity: 1;
  }
}
.logo__right {
  margin-left: 10px;
}
.logo__text {
  display: inline-block;
  font-size: 20px;
  font-weight: bold;
}
.logo__right:hover {
}
</style>
