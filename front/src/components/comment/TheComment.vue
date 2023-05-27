<template>
  <div class="comment">
    <div class="comment__box">
      <img class="comment__writer-img" :src="this.imgUrl" />
      <div class="comment__main">
        <div class="comment__up">
          <p class="comment__writer-nickname">{{ itemData.nickname }}</p>
          <p class="comment__createtime">{{ itemData.createTime }}</p>
        </div>
        <div class="comment__down"></div>
        <p class="comment__content">{{ itemData.content }}</p>
      </div>
    </div>
    <div class="comment__delete-btn">
      <button v-if="isWrite" @click.prevent="deleteComment">x</button>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "TheComment",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      comment: "",
      userNo: 0,
      isWrite: false,
      imgUrl: "",
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    } else {
      this.userNo = 0;
    }
    if (this.userNo === this.itemData.userNo) {
      this.isWrite = true;
    } else {
      this.isWrite = false;
    }
    this.loadImg();
  },
  props: ["itemData"],
  methods: {
    deleteComment() {
      if (confirm("정말 삭제하시겠습니까?")) {
        http.delete(`comment/${this.itemData.commentNo}`).then((response) => {
          console.log(response);
        });
      }
    },
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.itemData.imgSaveFolder}&saveFile=${this.itemData.imgSaveFile}`;
    },
  },
};
</script>

<style>
.comment {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 2px solid var(--color-lightwhite);
}
.comment__box {
  height: 100px;
  width: 1100px;
  display: flex;
  align-items: center;
  margin: 0px;
  padding: 0px 20px;
}
.comment__writer-img {
  width: 50px;
  height: 50px;
  border-radius: 70px;
  margin-right: 20px;
}
.comment__main {
  display: flex;
  flex-direction: column;
}
.comment__up {
  display: flex;
  margin-bottom: 10px;
  align-items: center;
}
.comment__writer-nickname {
  font-size: 18px;
  margin-right: 20px;
}
.comment__down {
  display: flex;
}
.comment__delete-btn button {
  background-color: transparent;
  color: red;
  font-size: 28px;
  padding: 20px;
}
</style>
