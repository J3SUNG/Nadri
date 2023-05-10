<template>
  <div class="signup">
    <form class="signup__form">
      <div class="signup__logo">
        <TheLogo />
      </div>
      <label class="signup__label signup__label-id">아이디</label>
      <input
        v-model="id"
        type="text"
        class="signup__input signup__input-id"
        placeholder="ID"
        pattern="^([a-z0-9_]){6,16}$"
        @input="TestInput"
      />
      <p class="signup__check signup__check-id">{{ idText }}</p>

      <label class="signup__label signup__label-pw">비밀번호</label>
      <input
        v-model="password"
        type="password"
        class="signup__input signup__input-pw"
        placeholder="Password"
        pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
      />
      <p class="signup__check signup__check-pw">{{ pwText }}</p>

      <label class="signup__label signup__label-pw">비밀번호 확인</label>
      <input
        v-model="passwordConfirm"
        type="password"
        class="signup__input signup__input-pw-confirm"
        placeholder="Password Confirm"
        pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
      /><br />
      <p class="signup__check signup__check-pw-confrim">{{ pwConText }}</p>

      <label class="signup__label signup__label-email">이메일</label>
      <input
        v-model="email"
        type="email"
        class="signup__input signup__input-email"
        placeholder="Email"
      />
      <p class="signup__check signup__check-email">{{ emailText }}</p>

      <label class="signup__label signup__label-nickname">닉네임</label>
      <input
        v-model="nickname"
        type="text"
        class="signup__input signup__input-nickname"
        placeholder="Nickname"
      />
      <p class="signup__check signup__check-nickname">{{ nickText }}</p>

      <button class="signup__btn signup__signup-btn">회원가입</button>
      <hr class="signup__hr" />
      <p class="signup__login-text">계정이 있으신가요?</p>
      <router-link class="signup__login-btn" :to="{ name: 'AppLogin' }">로그인</router-link>
    </form>
  </div>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";

export default {
  name: "TheSignup",
  components: { TheLogo },
  data() {
    return {
      id: "",
      password: "",
      passwordConfirm: "",
      email: "",
      nickname: "",
      idChk: 0, // 이미사용중이거나, 사용할 수 없는 아이디 형식입니다
      pwChk: 0, // 사용할수 없는 비밀번호 입니다.
      pwConChk: 0, // 두 비밀번호가 일치하지 않습니다.
      emailChk: 0, // 이메일 형식이 옳바르지 않습니다.
      chkNick: 0, // 이미사용중이거나, 사용할 수 없는 닉네임 형식입니다
      idText: "사용가능한 아이디 입니다.",
      pwText: "사용가능한 비밀번호 입니다.",
      pwConText: "사용가능한 비밀번호 입니다.",
      emailText: "사용가능한 이메일 입니다.",
      nickText: "사용가능한 닉네임 입니다.",
    };
  },
  methods: {
    TestInput: function (event) {
      console.log(event.currentTarget.validity);
    },
  },
  computed: {
    validate: function () {
      // 서버로 데이터 전송
      // reuslt에 결과값, 0 성공, 1 실패
      // result
      return this.message.split("").reverse().join("");
    },
  },
};
</script>

<style>
.signup {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.signup__form {
  border-radius: 20px;
  padding: 30px;
  width: 500px;
  background-color: white;
  box-shadow: 0px 0px 5px #444;
}
.signup__logo {
  margin-bottom: 20px;
}
.signup__label {
  width: 120px;
  text-align: left;
  font-weight: bold;
}
.signup__input {
  width: 300px;
  border-radius: 8px;
  padding: 15px;
}
.signup__check {
  padding-left: 170px;
  text-align: left;
  font-size: 12px;
  margin-bottom: 14px;
}
.signup__btn {
  background-color: orange;
  color: white;
  font-weight: bold;
  border: 0px;
  border-radius: 8px;
}
.signup__btn:hover {
  background-color: rgb(255, 140, 0);
}
.signup__signup-btn {
  width: 120px;
}
.signup__login-btn {
  width: 10px;
  color: orange;
}
.signup__login-btn:hover {
  color: rgb(255, 140, 0);
}
.signup__login-text {
  display: inline-block;
  margin-right: 8px;
}
.signup__hr {
  margin: 15px 10px;
  color: #444;
}
.signup__input:invalid {
  border-color: red;
}
.signup__input:valid {
  border-color: green;
}
</style>
