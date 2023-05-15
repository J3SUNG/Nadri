<template>
  <div class="logo" @click="logoClick">
    <img class="logo__img" alt="page logo" :src="img" />
    <h3 class="logo__text">놀러가자미</h3>
  </div>
</template>

<script>
export default {
  name: "TheLogo",
  data() {
    return {
      img: require("@/assets/flounder.png"),
      imgList: ["@/assets/flounder.png", "@/assets/street.png"],
    };
  },
  methods: {
    logoClick() {
      if (this.$route.path !== "/") {
        this.$router.push({ name: "AppHome" });
      }
    },
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
}
.logo__text {
  margin-left: 10px;
  font-size: 20px;
  font-weight: bold;
}
</style>
