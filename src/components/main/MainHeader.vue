<template>
  <header class="header">
    <div class="header__box">
      <TheLogo />
      <nav class="header__nav">
        <ul>
          <li><router-link :to="{ name: 'AppHome' }">홈</router-link> |</li>
          <li><router-link :to="{ name: 'AppMap' }">지도</router-link> |</li>
          <li>
            <router-link :to="{ name: 'AppBoard' }">게시판</router-link>
          </li>
        </ul>
      </nav>
      <aside class="header__login">
        <ul>
          <li><router-link :to="{ name: 'AppLogin' }">로그인</router-link> |</li>
          <li>
            <router-link :to="{ name: 'AppSignup' }">회원가입</router-link>
          </li>
        </ul>
      </aside>
    </div>
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
  width: 100%;
  height: 100px;
  position: fixed;
  display: flex;
  justify-content: center;
  box-shadow: 0px 0px 5px #444;
  background-color: white;
}
.header__box {
  width: 1140px;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
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
