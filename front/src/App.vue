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
@import url("https://fonts.googleapis.com/css?family=Gamja+Flower:400");
:root {
  --color-main: #e97723;
  --color-strong: #f66e00;
  --color-week: #ffa921;
  --color-week2: #fff3af;
  --color-tomato: tomato;
  --color-yellow: #d88500;
  --color-white: #ffffff;
  --color-darkgray: #444;
  --color-lightgray: lightgray;
  --color-black: black;
  --color-lightwhite: #ededed;
}
body {
  overflow-x: hidden;
}
* {
  margin: 0px;
  padding: 0px;
  font-family: "IBM Plex Sans KR", sans-serif;
  font-weight: bold;
  color: var(--color-darkgray);
}
table {
  border-spacing: 0;
}
textarea {
  resize: none;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  width: 100%;
  min-height: 100vh;
  position: relative;
  padding-bottom: 200px;
  background-color: var(--color-white);
}
#main {
  display: flex;
  justify-content: center;
  width: 100%;
  min-width: 1140px;
}
#main__box {
  width: 1140px;
  margin-top: 100px;
}
#header {
  z-index: 10;
  min-width: 1140px;
}
#footer {
  z-index: 10;
  min-width: 1140px;
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
  font-weight: bold;
  color: var(--color-black);
  opacity: 0.8;
}
a:hover {
  opacity: 1;
}
button {
  background-color: var(--color-main);
  padding: 14px 20px;
  margin: 8px 10px;
  border-radius: 4px;
  font-size: 18px;
  cursor: pointer;
  border: solid 0px var(--color-darkgray);
  color: var(--color-white);
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
  border: 1px solid var(--color-darkgray);
  border-radius: 4px;
  box-sizing: border-box;
  font-size: medium;
}
label {
  display: inline-block;
  width: 80px;
}
@keyframes fadeInUpUp {
  0% {
    opacity: 0;
    transform: translate3d(0, 100%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    transform: translate3d(0, -10%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}

/* kakao */
.customoverlay {
  position: relative;
  bottom: 85px;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  float: left;
}
.customoverlay:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.customoverlay a {
  display: block;
  text-decoration: none;
  color: #000;
  text-align: center;
  border-radius: 6px;
  font-size: 14px;
  font-weight: bold;
  overflow: hidden;
  background: #d95050;
  background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.customoverlay .title {
  display: block;
  text-align: center;
  background: #fff;
  margin-right: 35px;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
}
.customoverlay:after {
  content: "";
  position: absolute;
  margin-left: -12px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
</style>
