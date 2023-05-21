<template>
  <div class="mypage">
    <img class="mypage__user-img" :src="userImg" />
    <p>{{ this.nickname }}</p>
    <p>{{ this.email }}</p>
    <p>{{ this.createtime }}</p>
    <button @click="moveUserUpdate">회원 정보 수정</button>
    <button>회원 탈퇴</button>
  </div>
</template>

<script>
export default {
  name: "TheMypage",
  data() {
    return {
      userImg: require("@/assets/jetty.jpg"),
      nickname: "제티",
      email: "jetty@naver.com",
      createtime: "2023-05-21 04:46",
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
}
.mypage__user-img {
  width: 100px;
  height: 100px;
  border-radius: 70px;
}
</style>
