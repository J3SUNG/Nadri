<template>
  <div class="find-pwd">
    <form class="find-pwd__form" ref="form" @submit.prevent="sendEmail">
      <div class="find-pwd__logo">
        <TheLogo />
      </div>

      <label class="find-pwd__label find-pwd__label-id">아이디</label>
      <input
        v-model="userData.id"
        type="text"
        class="find-pwd__input find-pwd__input-id"
        placeholder="아이디"
        maxlength="16"
        name="user_name"
      />

      <label class="find-pwd__label find-pwd__label-email">이메일</label>
      <input
        v-model="userData.email"
        type="email"
        class="find-pwd__input find-pwd__input-email"
        placeholder="이메일"
        maxlength="30"
        name="user_email"
      />

      <label
        :class="{
          'find-pwd__label': true,
          'find-pwd__label-code': true,
          'find-pwd__hide': !isReceive,
        }"
        >인증번호</label
      >
      <input
        :class="{
          'find-pwd__input': true,
          'find-pwd__input-code': true,
          'find-pwd__hide': !isReceive,
        }"
        v-model="code"
        type="text"
        placeholder="인증번호 입력"
      />
      <input
        class="find-pwd__input-send"
        type="submit"
        value="인증번호 전송"
        @click="receiveEmail"
      />
      <div class="find-pwd__input-confirm__box">
        <button
          :class="{ 'find-pwd__input-confirm': true, 'find-pwd__input-confirm-hide': !isReceive }"
          @click="initConfirm"
        >
          확인
        </button>
      </div>

      <hr class="find-pwd__hr" />
      <p class="find-pwd__login-text">계정이 있으신가요?</p>
      <router-link class="find-pwd__login-btn" :to="{ name: 'AppLogin' }">로그인</router-link>
    </form>
  </div>
</template>

<script>
import TheLogo from "../logo/TheLogo.vue";
import http from "@/util/http-common";
import emailjs from "@emailjs/browser";

export default {
  name: "Thefind-pwd",
  components: { TheLogo },
  created() {},
  data() {
    return {
      userData: {
        id: "",
        email: "",
      },
      isReceive: false,
      code: "",
    };
  },
  methods: {
    findPwdClick(event) {
      event.preventDefault();
      alert("패스워드가 123456으로 초기화 되었습니다.");
    },
    sendEmail() {
      emailjs
        .sendForm("service_2n44egk", "template_seiedvb", this.$refs.form, "398B1fGm4-6uoAf3u")
        .then(
          (result) => {
            console.log("SUCCESS!", result.text);
          },
          (error) => {
            console.log("FAILED...", error.text);
          }
        );
    },
    initConfirm() {
      if (this.code === "061410") {
        http.post(`user/change/${this.userData.id}`).then((response) => {
          console.log(response);
          alert(`비밀번호가 "123456"으로 초기화 되었습니다. 다시 로그인 해주세요.`);
          this.$router.push({ name: "AppLogin" });
        });
      } else {
        alert("인증번호가 일치하지 않습니다.");
      }
    },
    receiveEmail() {
      this.isReceive = true;
    },
  },
  mounted() {
    this.activeButton = true;
  },
};
</script>

<style>
.find-pwd {
  display: flex;
  justify-content: center;
  align-items: center;
}
.find-pwd__form {
  padding: 30px;
  width: 500px;
  background-color: var(--color-white);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.find-pwd__logo {
  width: 160px;
  margin-bottom: 20px;
}
.find-pwd__label {
  width: 120px;
  text-align: left;
  font-weight: bold;
}
.find-pwd__input {
  width: 300px;
  border-radius: 8px;
  padding: 15px;
}
.find-pwd__btn {
  font-weight: bold;
  border: 0px;
  border-radius: 5px;
}
.find-pwd__login-btn {
  color: var(--color-main);
  width: 10px;
}
.find-pwd__login-text {
  display: inline-block;
  margin-right: 8px;
  font-weight: bold;
}
.find-pwd__hr {
  margin: 15px 10px;
  color: var(--color-darkgray);
}
.find-pwd__input-send {
  width: auto;
  background-color: var(--color-main);
  color: var(--color-white);
  border: 0px solid var(--color-white);
  border-radius: 8px;
  padding: 10px 10px;
  margin: 0px 10px;
  cursor: pointer;
  height: 55px;
}
.find-pwd__input-confirm {
  text-align: center;
  display: block;
  width: auto;
  background-color: var(--color-main);
  color: var(--color-white);
  border: 0px solid var(--color-white);
  border-radius: 8px;
  padding: 10px 10px;
  margin: 10px 10px;
  cursor: pointer;
  width: 80px;
}
.find-pwd__hide {
  visibility: hidden;
}
.find-pwd__input-code {
  margin-left: 10px;
  width: 180px;
}
.find-pwd__input-confirm-hide {
  visibility: hidden;
}
.find-pwd__input-confirm__box {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%px;
}
</style>
