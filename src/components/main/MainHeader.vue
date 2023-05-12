<template>
  <header class="header">
    <TheLogo />
    <nav class="header__nav">
      <router-link :to="{ name: 'AppHome' }">홈</router-link> |
      <router-link :to="{ name: 'AppMap' }">지도</router-link> |
      <router-link :to="{ name: 'AppBoard' }">게시판</router-link>
    </nav>
    <aside class="header__login">
      <router-link :to="{ name: 'AppLogin' }">로그인</router-link> |
      <router-link :to="{ name: 'AppSignup' }">회원가입</router-link>
    </aside>
  </header>
</template>

<script>
import TheLogo from "@/components/logo/TheLogo.vue";

export default {
  name: "MainHeader",
  components: { TheLogo },
};
</script>

<style>
.header {
  width: 100vw;
  height: 100px;
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: space-around;
  box-shadow: 0px 0px 5px #444;
  background-color: white;
}
.header__nav {
  padding: 30px;
}

.header__nav a {
  font-weight: bold;
  color: #2c3e50;
}
.header__nav a:hover {
  color: rgb(255, 203, 106);
}
.header__nav a.router-link-exact-active {
  color: orange;
}
</style>
