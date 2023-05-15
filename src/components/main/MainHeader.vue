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
            <router-link :to="{ name: 'AppHome' }">계획세우기</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppNotify' }">공지사항</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppBoard' }">게시판</router-link>
          </li>
        </ul>
      </nav>
      <aside class="header__login">
        <ul>
          <li class="header__login__item header__login__item-login">
            <router-link :to="{ name: 'AppLogin' }">로그인</router-link>
          </li>
          <li class="header__login__item header__login__item-signup">
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
.header__login__item {
  display: flex;
  align-items: center;
  justify-content: center;
}
.header__login__item > a {
  position: relative;
  font-size: 18px;
  width: 100%;
  padding: 15px 0px;
}
.header__login__item-login {
  width: 100px;
  height: 50px;
  border-radius: 10px;
  border: 3px solid var(--color1-blue);
  background-color: var(--color1-blue);
}
.header__login__item-signup {
  width: 100px;
  height: 50px;
  border: 3px solid var(--color1-blue);
  border-radius: 10px;
  background-color: var(--color5-white);
  margin-left: 10px;
}
.header__login__item-login > a {
  color: var(--color5-white);
}
.header__login__item-signup > a {
  color: var(--color1-blue);
}
</style>
