<template>
  <div id="app">
    <main-header id="header" />
    <main id="main">
      <router-view />
    </main>
    <main-footer id="footer" />
  </div>
</template>

<script>
import MainHeader from "./components/main/MainHeader.vue";
import MainFooter from "./components/main/MainFooter.vue";

export default {
  name: "App",
  components: {
    MainHeader,
    MainFooter,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap");

body {
  overflow-x: hidden;
}
body,
h1,
h2,
h3,
h4,
h5,
h6,
p,
span,
a,
button {
  margin: 0px;
  padding: 0px;
  font-family: "IBM Plex Sans KR", sans-serif;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100vw;
  height: 100vh;
  background-color: whitesmoke;
}
#main {
  width: 100%;
  height: 100%;
}
a {
  text-decoration: none;
  color: orange;
  font-weight: bold;
}
</style>
