<template>
  <div class="signup">
    <form class="signup__form">
      <div class="signup__logo">
        <TheLogo />
      </div>
      <label class="signup__label signup__label-id">아이디</label>
      <input
        v-model="userData.id"
        type="text"
        class="signup__input signup__input-id"
        placeholder="ID"
        pattern="^([a-z0-9_]){6,16}$"
        title="형식: 6~16글자, 영어와 숫자를 포함한 아이디를 입력하세요."
        @input="checkValidate"
        required="required"
        maxlength="16"
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
        v-model="userData.password"
        type="password"
        class="signup__input signup__input-pw"
        placeholder="Password"
        pattern="^[A-Za-z\d$@$!%*#?&]{6,16}$"
        title="형식: 6~16글자, 영어, 숫자, 특수문자를 사용하실 수 있습니다. 영어와 숫자를 포함한 비밀번호를 입력하세요."
        @input="checkValidate"
        required="required"
        maxlength="16"
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
        pattern="^[A-Za-z\d$@$!%*#?&]{6,16}$"
        @input="checkValidate"
        required="required"
        maxlength="16"
        ref="pwdConfirm"
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
        v-model="userData.email"
        type="email"
        class="signup__input signup__input-email"
        placeholder="Email"
        pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}"
        @input="checkValidate"
        required="required"
        maxlength="30"
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
        v-model="userData.nickname"
        type="text"
        class="signup__input signup__input-nickname"
        placeholder="Nickname"
        pattern="^([a-z0-9_]){2,16}$"
        @input="checkValidate"
        required="required"
        maxlength="16"
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
      <button
        :class="{
          'sginup__btn__non-active': activeButton,
          signup__btn: true,
          'signup__signup-btn': true,
        }"
        @click.prevent="moveHome"
      >
        회원가입
      </button>
      <hr class="signup__hr" />
      <p class="signup__login-text">계정이 있으신가요?</p>
      <router-link class="signup__login-btn" :to="{ name: 'AppLogin' }">로그인</router-link>
    </form>
  </div>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";
import http from "@/util/http-common";

export default {
  name: "TheSignup",
  components: { TheLogo },
  data() {
    return {
      userData: {
        id: "",
        password: "",
        email: "",
        nickname: "",
      },
      passwordConfirm: "",
      attrChk: [false, false, false, false, false],
      attrText: ["ㅤ", "ㅤ", "ㅤ", "ㅤ", "ㅤ"],
      attr: ["아이디", "비밀번호", "비밀번호", "이메일", "닉네임"],
      activeButton: false,
      duplicateId: false,
    };
  },
  methods: {
    moveHome() {
      if (
        this.attrChk[0] &&
        this.attrChk[1] &&
        this.attrChk[2] &&
        this.attrChk[3] &&
        this.attrChk[4]
      ) {
        http.post(`user`, JSON.stringify(this.userData)).then((response) => {
          console.log(response);
          if (response.data === "success") {
            alert(`환영합니다. ${this.userData.nickname}님.`);
            this.$router.push({ name: "AppHome" });
          } else {
            alert("회원가입에 실패하였습니다. 다시 시도 해주세요.");
          }
        });
      }
    },
    checkValidate(event) {
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
        this.attrText[index] = `ㅤ`;
        this.attrChk[index] = true;
      }

      if (index === 0 && this.attrChk[0]) {
        http.get(`user/check?field=id&val=${this.userData.id}`).then((response) => {
          if (response.data !== "success") {
            event.target.setCustomValidity("중복 된 아이디입니다.");
            this.attrText[0] = `중복 된 아이디입니다.`;
            this.attrChk[0] = false;
            this.toggleButton();
            this.$forceUpdate();
          } else {
            event.target.setCustomValidity("");
          }
        });
      } else if ((index === 1 || index === 2) && (this.attrChk[1] || this.attrChk[2])) {
        if (this.userData.password === this.passwordConfirm) {
          this.$refs.pwdConfirm.setCustomValidity("");
          this.attrChk[1] = true;
          this.attrChk[2] = true;
          this.attrText[2] = `ㅤ`;
        } else {
          this.$refs.pwdConfirm.setCustomValidity("비밀번호가 일치하지 않습니다.");
          this.attrText[2] = `비밀번호가 일치하지 않습니다.`;
          this.attrChk[2] = false;
          this.toggleButton();
        }
      } else if (index === 3 && this.attrChk[3]) {
        http.get(`user/check?field=email&val=${this.userData.email}`).then((response) => {
          if (response.data !== "success") {
            event.target.setCustomValidity("중복 된 이메일입니다.");
            this.attrText[3] = `중복 된 이메일입니다.`;
            this.attrChk[3] = false;
            this.toggleButton();
            this.$forceUpdate();
          } else {
            event.target.setCustomValidity("");
          }
        });
      } else if (index === 4 && this.attrChk[4]) {
        http.get(`user/check?field=nickname&val=${this.userData.nickname}`).then((response) => {
          if (response.data !== "success") {
            event.target.setCustomValidity("중복 된 닉네임입니다.");
            this.attrText[4] = `중복 된 닉네임입니다.`;
            this.attrChk[4] = false;
            this.toggleButton();
            this.$forceUpdate();
          } else {
            event.target.setCustomValidity("");
          }
        });
      }
      this.toggleButton();
    },
    toggleButton() {
      console.log("AA");
      if (
        this.attrChk[0] &&
        this.attrChk[1] &&
        this.attrChk[2] &&
        this.attrChk[3] &&
        this.attrChk[4]
      ) {
        this.activeButton = false;
      } else {
        this.activeButton = true;
      }
    },
    signupClick(event) {
      event.preventDefault();
    },
  },
  mounted() {
    this.activeButton = true;
  },
};
</script>

<style>
.signup {
  display: flex;
  justify-content: center;
  align-items: center;
}
.signup__form {
  padding: 30px;
  width: 500px;
  background-color: var(--color-white);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.signup__logo {
  width: 160px;
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
  font-weight: bold;
  border: 0px;
  border-radius: 5px;
}
.signup__signup-btn {
  width: 120px;
}
.signup__login-btn {
  color: var(--color-main);
  width: 10px;
}
.signup__login-text {
  display: inline-block;
  margin-right: 8px;
  font-weight: bold;
}
.signup__hr {
  margin: 15px 10px;
  color: var(--color-darkgray);
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
.sginup__btn__non-active {
  pointer-events: none;
  opacity: 0.6;
}
</style>
