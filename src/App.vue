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

:root {
  --color1-blue: #587fff;
  --color2-purple: #b6b9f0;
  --color3-lightblue: #edeeff;
  --color4-brown: #c0a975;
  --color5-white: #ffffff;
  --color6-darkgray: #444;
  --color7-lightgray: lightgray;
  --color8-black: black;
}

body {
  overflow-x: hidden;
}
* {
  margin: 0px;
  padding: 0px;
  font-family: "IBM Plex Sans KR", sans-serif;
}
table {
  border-spacing: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  width: 100%;
  height: 100vh;
  background-color: var(--color3-lightblue);
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
  margin-top: 120px;
}
#header {
  z-index: 10;
}
#footer {
  z-index: 10;
}
ul {
  display: flex;
  flex-direction: row;
}
li {
  list-style: none;
  padding-left: 0px;
}
a {
  text-decoration: none;
  color: var(--color1-blue);
  font-weight: bold;
}
a:hover {
  opacity: 0.9;
}
button {
  background-color: var(--color1-blue);
  padding: 14px 20px;
  margin: 8px 10px;
  border-radius: 4px;
  font-size: 18px;
  cursor: pointer;
  border: solid 0px var(--color6-darkgray);
  color: var(--color5-white);
}
button:hover {
  opacity: 0.9;
}
input,
select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid var(--color6-darkgray);
  border-radius: 4px;
  box-sizing: border-box;
  font-size: medium;
}
label {
  display: inline-block;
  width: 80px;
}
</style>
