<template>
  <div class="login">
    <form class="login__form">
      <div class="login__logo">
        <TheLogo />
      </div>
      <input v-model="id" class="login__input login__input-id" placeholder="ID" />
      <input v-model="password" class="login__input login__input-pw" placeholder="Password" />
      <button class="login__btn login__login-btn">로그인</button>
      <router-link class="login__find-pw" :to="{ name: 'AppFindPassword' }"
        >비밀번호를 잊으셨나요?</router-link
      >
      <hr class="login__hr" />
      <button class="login__btn login__signup-btn">회원가입</button>
    </form>
  </div>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";

export default {
  name: "TheLogin",
  components: { TheLogo },
  data() {
    return {
      id: "",
      password: "",
    };
  },
};
</script>

<style>
.login {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login__form {
  display: flex;
  border-radius: 20px;
  padding: 30px;
  width: 500px;
  background-color: white;
  box-shadow: 0px 0px 5px #444;
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
.login__btn {
  background-color: orange;
  color: white;
  font-weight: bold;
  border: 0px;
  border-radius: 8px;
}
.login__btn:hover {
  background-color: rgb(255, 140, 0);
}
.login__login-btn {
  width: 300px;
}
.login__signup-btn {
  width: 150px;
}
.login__find-pw {
  color: orange;
}
.login__find-pw:hover {
  color: rgb(255, 140, 0);
}
.login__hr {
  width: 100%;
  margin: 20px 0px;
}
</style>
