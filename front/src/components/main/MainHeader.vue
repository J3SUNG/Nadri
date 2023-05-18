<template>
  <header class="header">
    <div class="header__box">
      <TheLogo />
      <nav class="header__nav">
        <ul>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppMap' }">여행지정보</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppPlan' }">여행노트</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppBoard' }">커뮤니티</router-link>
          </li>
          <li class="header__nav__item">
            <router-link :to="{ name: 'AppNotify' }">공지사항</router-link>
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
  height: 80px;
  position: fixed;
  display: flex;
  justify-content: center;
  box-shadow: 0px 0px 5px var(--color-darkgray);
  background-color: var(--color-white);
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
  font-size: 22px;
  margin: 0px 20px;
  height: 100%;
  display: inline-block;
  position: relative;
}
.header__nav__item a:hover {
  color: var(--color-main);
}
.header__nav__item a::after {
  content: "";
  position: absolute;
  bottom: -24px;
  left: 50%;
  width: 0;
  height: 0;
  background-color: var(--color-main);
  transition: all 350ms;
}
.header__nav__item a:hover::after {
  left: 0;
  width: 100%;
  height: 5px;
}
.header__login__item {
  display: flex;
  align-items: center;
  justify-content: center;
}
.header__login__item > a {
  position: relative;
  font-size: px;
  width: 100%;
  padding: 15px 0px;
  opacity: 1;
}
.header__login__item-login {
  width: 80px;
  height: 40px;
  border-radius: 10px;
  border: 3px solid var(--color-main);
  background-color: var(--color-main);
}
.header__login__item-signup {
  width: 80px;
  height: 40px;
  border: 3px solid var(--color-main);
  border-radius: 10px;
  background-color: var(--color-white);
  margin-left: 10px;
}
.header__login__item-login > a {
  color: var(--color-white);
}
.header__login__item-signup > a {
  color: var(--color-main);
}
</style>
