<template>
  <div class="mypage">
    <div class="mypage__header">
      <img class="mypage__header-img" :src="userImg" />
      <div class="mypage__header-info__box mypage__header-info__box-id">
        <p class="mypage__header-info">아이디</p>
        <p class="mypage__header-info__data">{{ this.id }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-nickname">
        <p class="mypage__header-info">닉네임</p>
        <p class="mypage__header-info__data">{{ this.nickname }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-email">
        <p class="mypage__header-info">이메일</p>
        <p class="mypage__header-info__data">{{ this.email }}</p>
      </div>
      <div class="mypage__header-button__box">
        <button class="mypage__header-button mypage__header-button__update" @click="moveUserUpdate">
          프로필수정
        </button>
        <button class="mypage__header-button mypage__header-button__delete">회원탈퇴</button>
      </div>
    </div>
    <div class="mypage__main"></div>
  </div>
</template>

<script>
export default {
  name: "TheMypage",
  data() {
    return {
      userImg: require("@/assets/jetty.jpg"),
      id: "jetty1234",
      nickname: "제티먹은콜라",
      email: "jetty1234@naver.com",
    };
  },
  methods: {
    moveUserUpdate() {
      this.$router.push({ name: "AppUserUpdate" });
    },
  },
};
</script>

<style>
.mypage {
  width: 80%;
  margin-left: 10%;
}
.mypage__header {
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 20px;
  border-bottom: 1px solid var(--color-lightgray);
}
.mypage__header-img {
  width: 100px;
  height: 100px;
  border-radius: 70px;
}
.mypage__header-info__box {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  width: 160px;
  height: 60px;
}
.mypage__header-info__box-id {
  width: 140px;
}
.mypage__header-info__box-nickname {
  width: 140px;
}
.mypage__header-info__box-email {
  width: 180px;
}
.mypage__header-info {
  font-size: 16px;
}
.mypage__header-info__data {
  font-size: 16px;
}
.mypage__header-button {
  font-size: 14px;
  height: 40px;
  width: 100px;
  padding: 0px;
  border: 0px solid var(--color-white);
  background-color: var(--color-week);
  color: var(--color-white);
  margin: 5px;
  border-radius: 10px;
}
.mypage__header-button__update {
  background-color: var(--color-week);
}
.mypage__header-button__delete {
  background-color: var(--color-tomato);
}
</style>
