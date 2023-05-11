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
        @input="CheckValidate"
        required="required"
      />
      <p
        :class="{
          'signup__check--green': attrChk[0],
          'signup__check--red': !attrChk[0],
          signup__check: true,
          'signup__check-id': true,
        }"
      >
        {{ attrText[0] }}
      </p>

      <label class="signup__label signup__label-pw">비밀번호</label>
      <input
        v-model="password"
        type="password"
        class="signup__input signup__input-pw"
        placeholder="Password"
        pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d$@$!%*#?&]{6,16}$"
        @input="CheckValidate"
        required="required"
      />
      <p
        :class="{
          'signup__check--green': attrChk[1],
          'signup__check--red': !attrChk[1],
          signup__check: true,
          'signup__check-pw': true,
        }"
      >
        {{ attrText[1] }}
      </p>

      <label class="signup__label signup__label-pw">비밀번호 확인</label>
      <input
        v-model="passwordConfirm"
        type="password"
        class="signup__input signup__input-pw-confirm"
        placeholder="Password Confirm"
        pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d$@$!%*#?&]{6,16}$"
        @input="CheckValidate"
        required="required"
      /><br />
      <p
        :class="{
          'signup__check--green': attrChk[2],
          'signup__check--red': !attrChk[2],
          signup__check: true,
          'signup__check-pw-confirm': true,
        }"
      >
        {{ attrText[2] }}
      </p>

      <label class="signup__label signup__label-email">이메일</label>
      <input
        v-model="email"
        type="email"
        class="signup__input signup__input-email"
        placeholder="Email"
        pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}"
        @input="CheckValidate"
        required="required"
      />
      <p
        :class="{
          'signup__check--green': attrChk[3],
          'signup__check--red': !attrChk[3],
          signup__check: true,
          'signup__check-email': true,
        }"
      >
        {{ attrText[3] }}
      </p>

      <label class="signup__label signup__label-nickname">닉네임</label>
      <input
        v-model="nickname"
        type="text"
        class="signup__input signup__input-nickname"
        placeholder="Nickname"
        pattern="^([a-z0-9_]){2,16}$"
        @input="CheckValidate"
        required="required"
      />
      <p
        :class="{
          'signup__check--green': attrChk[4],
          'signup__check--red': !attrChk[4],
          signup__check: true,
          'signup__check-nickname': true,
        }"
      >
        {{ attrText[4] }}
      </p>

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
      attrChk: [true, true, true, true, true],
      attrText: ["ㅤ", "ㅤ", "ㅤ", "ㅤ", "ㅤ"],
      attr: ["아이디", "비밀번호", "비밀번호", "이메일", "닉네임"],
    };
  },
  methods: {
    CheckValidate: function (event) {
      let index = 0;
      if (event.target.classList[1] === "signup__input-id") {
        index = 0;
      } else if (event.target.classList[1] === "signup__input-pw") {
        index = 1;
      } else if (event.target.classList[1] === "signup__input-pw-confirm") {
        index = 2;
      } else if (event.target.classList[1] === "signup__input-email") {
        index = 3;
      } else if (event.target.classList[1] === "signup__input-nickname") {
        index = 4;
      }

      if (
        event.currentTarget.validity.patternMismatch ||
        event.currentTarget.validity.valueMissing
      ) {
        this.attrText[index] = `사용할 수 없는 ${this.attr[index]} 입니다.`;
        this.attrChk[index] = false;
      } else {
        this.attrText[index] = `사용가능한 ${this.attr[index]} 입니다.`;
        this.attrChk[index] = true;
      }
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
.signup__check--red {
  color: red;
}
.signup__check--green {
  color: green;
}
</style>
