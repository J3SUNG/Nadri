<template>
  <div class="home">
    <img alt="page logo" src="../assets/logo.png" />
    <TheHome msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import TheHome from "@/components/home/TheHome.vue";

export default {
  name: "AppHome",
  components: {
    TheHome,
  },
};
</script>
