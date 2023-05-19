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
        <ul v-if="userInfo">
          <li class="header__login__item header__login__item-logout">
            <div @click="logoutClick">로그아웃</div>
          </li>
          <li class="header__login__item header__login__item-mypage">
            <router-link :to="{ name: 'AppMypage' }">마이페이지</router-link>
          </li>
        </ul>
        <ul v-else>
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
import { mapActions, mapGetters, mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MainHeader",
  components: { TheLogo },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    // ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    logoutClick() {
      // this.SET_IS_LOGIN(false);
      // this.SET_USER_INFO(null);
      // sessionStorage.removeItem("access-token");
      // if (this.$route.path != "/") this.$router.push({ name: "main" });
      console.log(this.userInfo.id);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.id);
      this.userLogout(this.userInfo.id);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "AppHome" });
    },
  },
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
  cursor: pointer;
}
.header__login__item > a {
  position: relative;
  width: 100%;
  padding: 15px 0px;
  opacity: 1;
}
.header__login__item-login,
.header__login__item-logout {
  width: 80px;
  height: 40px;
  border-radius: 10px;
  border: 3px solid var(--color-main);
  background-color: var(--color-main);
}
.header__login__item-signup,
.header__login__item-mypage {
  width: 80px;
  height: 40px;
  border: 3px solid var(--color-main);
  border-radius: 10px;
  background-color: var(--color-white);
  margin-left: 10px;
}
.header__login__item-login > a,
.header__login__item-logout > div {
  color: var(--color-white);
}
.header__login__item-signup > a,
.header__login__item-mypage > a {
  color: var(--color-main);
}
</style>
