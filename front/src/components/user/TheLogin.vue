<template>
  <div class="login">
    <form class="login__form">
      <div class="login__logo">
        <TheLogo />
      </div>
      <input v-model="id" class="login__input login__input-id" placeholder="ID" />
      <input
        type="password"
        v-model="password"
        class="login__input login__input-pw"
        placeholder="Password"
      />
      <button @click.prevent="confirm" class="login__btn login__login-btn">로그인</button>
      <router-link class="login__find-pw" :to="{ name: 'AppFindPwd' }"
        >비밀번호를 잊으셨나요?</router-link
      >
      <hr class="login__hr" />
      <button @click.prevent="moveSignup" class="login__btn login__signup-btn">회원가입</button>
    </form>
  </div>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";
// import http from "@/util/http-common";
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "TheLogin",
  components: { TheLogo },
  data() {
    return {
      id: "",
      password: "",
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      let user = {
        id: this.id,
        password: this.password,
      };
      await this.userConfirm(user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "AppHome" });
      } else {
        alert("아이디 또는 비밀번호가 일치하지 않습니다.");
      }
    },
    // clickLogin() {
    //   let userData = {
    //     id: this.id,
    //     pw: this.password,
    //   };
    //   http.post(`login`, JSON.stringify(userData)).then((response) => {
    //     if (response.data === "success") {

    //       this.$router.push({ name: "AppHome" });
    //     } else {
    //       alert("아이디 또는 비밀번호가 일치하지 않습니다.");
    //     }
    //   });
    // },
    moveSignup() {
      this.$router.push({ name: "AppSignup" });
    },
  },
};
</script>

<style>
.login {
  margin-top: 100px;
  height: 460px;
  display: flex;
  justify-content: center;
}
.login__form {
  display: flex;
  padding: 30px;
  width: 500px;
  background-color: var(--color-white);
  box-shadow: 0px 0px 5px var(--color-darkgray);
  flex-direction: column;
  align-items: center;
}
.login__logo {
  align-self: flex-start;
  margin-bottom: 10px;
}
.login__input {
  width: 300px;
  border-radius: 8px;
  padding: 15px;
}
.login__find-pw {
  color: var(--color-main);
}
.login__btn {
  font-weight: bold;
  border: 0px;
  border-radius: 8px;
}
.login__login-btn {
  width: 300px;
}
.login__signup-btn {
  width: 150px;
}
.login__hr {
  width: 100%;
  margin: 20px 0px;
}
</style>
