<template>
  <div id="app">
    <main-header id="header" />
    <main id="main">
      <div id="main__box">
        <router-view />
      </div>
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
  width: 100%;
  height: 100vh;
  background-color: #f6f1f1;
}
#main {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
}
#main__box {
  width: 1140px;
  height: 100%;
}
a {
  text-decoration: none;
  color: #146c94;
  font-weight: bold;
}
ul {
  display: flex;
  flex-direction: row;
}
li {
  list-style: none;
  padding-left: 0px;
}
</style>
