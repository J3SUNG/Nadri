<template>
  <div class="board__update">
    <div class="board__update__box">
      <input class="board__update__subject" placeholder="제목을 입력하세요" v-model="subject" />
      <hr class="board__update__hr" />
      <textarea
        class="board__update__content"
        placeholder="내용을 입력하세요"
        v-model="content"
      ></textarea>
      <hr class="board__update__hr" />
      <div class="board__update__footer">
        <div class="board__update__img-btn__box">
          <input
            class="board__update__img-btn"
            name="file"
            id="file"
            multiple
            ref="inputImage"
            type="file"
            value="사진"
            placeholder="사진"
            @change="updateImg"
          />
        </div>
        <!-- <img class="board__update__button board__update__button-img" src="@/assets/file.png" /> -->
        <!-- 서버에 요청 보내기 -->
        <div class="board__update__button board__update__button-a" @click="createBoard">
          <p>수정하기</p>
        </div>
      </div>
    </div>
    <!-- <input @change="upload" multiple accept="image/*" type="file" id="file" class="inputfile" /> -->
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http-common";

const memberStore = "memberStore";

export default {
  name: "BoardUpdate",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  mounted() {},
  data() {
    return {
      board: "",
      image: "",
      content: "",
      subject: "",
      type: 1,
      userNo: 0,
      boardNo: 0,
      filename: "does not exist file",
    };
  },
  async created() {
    this.boardNo = this.$route.params.boardNo;
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    const response = await http.get(`board/${this.$route.params.boardNo}/${this.userNo}`);
    this.board = response.data;
    this.type = this.board.boardType;
    this.subject = this.board.subject;
    this.content = this.board.content;
  },
  methods: {
    createBoard() {
      // var frm = new FormData();
      // var files = this.image;
      // for (let i = 0; i < files.length; i++) {
      //   frm.append("imgs", files[i]);
      // }
      // frm.append("subject", this.subject);
      // frm.append("content", this.content);
      // frm.append("userNo", this.userInfo.userNo);
      // frm.append("boardType", this.type);
      //http://192.168.31.78:7777/board?boardNo=355&content=ㅁㄴㅇ리ㅏㅓㄴ미ㅏ얼&subject=수정된 제목
      console.log(this.boardNo);
      http
        .put(`board?boardNo=${this.boardNo}&content=${this.content}&subject=${this.subject}`)
        .then(() => {
          if (this.type === 0) {
            this.$router.push({ name: "AppNotify" });
          } else {
            this.$router.push({ name: "AppBoard" });
          }
        });
    },
    updateImg() {
      this.image = this.$refs.inputImage.files;
      this.files = this.image;
      console.log(this.image);
      console.log(this.files);
    },
  },
};
</script>

<style>
.board__update {
  display: flex;
  align-items: center;
  flex-direction: column;
}
.board__update input:focus,
textarea:focus {
  outline: none;
}
/* .board__update__title {
  text-align: left;
  width:100%;
  margin-bottom: 20px;
  margin-left: 40%;
} */
.board__update__hr {
  color: lightgray;
  width: 100%;
  opacity: 0.4;
}
.board__update__box {
  margin-top: 40px;
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.board__update__box * {
  margin: 0px;
}
.board__update__box input {
  width: clac(100% - 60px);
  padding: 12px 30px;
  border-radius: 0px;
  border: 0px solid var(--color-lightgray);
}
.board__update__box textarea {
  width: calc(100% - 60px);
  height: 20em;
  padding: 30px;
  border: 0px solid var(--color-lightgray);
}
.board__update__subject {
  font-size: 32px;
  border: 10px solid black;
}
.board__update__content {
  font-size: 18px;
  height: 50%;
}

.board__update__img-btn {
  border-radius: 8px;
  width: 300px;
  padding: 0px;
  margin: 0px;
  cursor: pointer;
}

.board__update__footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 96%;
  padding: 0 2%;
  height: 60px;
  border: 0px solid var(--color-lightgray);
  background-color: var(--color-white);
}
.board__update__button {
  width: 40px;
  height: 40px;
  cursor: pointer;
}
.board__update__button-a {
  font-size: 20px;
  height: auto;
  width: auto;
}
</style>
