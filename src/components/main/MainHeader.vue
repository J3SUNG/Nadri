<template>
  <header class="header">
    <div class="header__box">
      <TheLogo />
      <nav class="header__nav">
        <ul>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppMap' }">놀러가자</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppBoard' }">계획세우기</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppMap' }">공지사항</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppBoard' }">게시판</router-link>
          </li>
        </ul>
      </nav>
      <aside class="header__login">
        <ul>
          <li class="header__login__item">
            <router-link :to="{ name: 'AppLogin' }">로그인</router-link>
          </li>
          <li class="header__login__item">
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
  box-shadow: 0px 0px 5px var(--color6-darkgray);
  background-color: var(--color5-white);
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
.header__nav__item {
  font-size: 18px;
  margin: 0px 20px;
}
.header__login__item > a {
  font-size: 18px;
  margin: 0px 10px;
  color: var(--color4-brown);
}
</style>
