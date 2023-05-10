<template>
  <main class="login">
    <form class="login__form">
      <div class="login__logo">
        <TheLogo />
      </div>
      <input class="login__input login__input-id" placeholder="ID" /><br />
      <input class="login__input login__input-pw" placeholder="Password" /><br />
      <button class="login__btn login__login-btn">로그인</button>
      <a class="login__find-pw" href="#">비밀번호를 잊으셨나요?</a><br /><br />
      <hr class="login__hr" />
      <br />
      <button class="login__btn login__signup-btn">새 계정 만들기</button>
    </form>
  </main>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";

export default {
  name: "TheLogin",
  components: { TheLogo },
};
</script>

<style>
.login {
  height: 85%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login__form {
  border-radius: 20px;
  padding: 30px;
  width: 500px;
  background-color: white;
  box-shadow: 0px 0px 5px #444;
}
.login__logo {
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
  width: 100px;
}
.login__signup-btn {
  width: 170px;
}
.login__find-pw {
  color: orange;
}
.login__find-pw:hover {
  color: rgb(255, 140, 0);
}
.login__hr {
  margin: 0 10px;
  color: #444;
}
</style>
