<template>
  <div class="logo" @click="logoClick">
    <!-- <img class="logo__img" alt="page logo" :src="img" /> -->
    <img class="logo__img" alt="page logo" src="@/assets/parasol.png" />
    <div class="logo__right">
      <h3 class="logo__text">나들이</h3>
      <img class="logo__text__img" src="@/assets/dot.png" />
    </div>
  </div>
</template>

<script>
export default {
  name: "TheLogo",
  data() {
    return {};
  },
  methods: {
    logoClick() {
      if (this.$route.path !== "/") {
        this.$router.push({ name: "AppHome" });
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
.logo__right {
  margin-left: 10px;
  position: relative;
}
.logo__text {
  display: inline-block;
  font-weight: bold;
  font-family: "Gamja Flower";
  font-size: 40px;
}
.logo__text__img {
  width: 20px;
  height: 20px;
  position: absolute;
  right: -8px;
  top: 0px;
}
</style>
