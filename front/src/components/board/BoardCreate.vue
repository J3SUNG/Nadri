<template>
  <div class="board__create">
    <div class="board__create__box">
      <input class="board__create__subject" placeholder="제목을 입력하세요" v-model="subject" />
      <hr class="board__create__hr" />
      <textarea
        class="board__create__content"
        placeholder="내용을 입력하세요"
        v-model="content"
      ></textarea>
      <hr class="board__create__hr" />
      <div class="board__create__footer">
        <div class="board__create__img-btn__box">
          <input
            class="board__create__img-btn"
            name="file"
            id="file"
            multiple
            ref="inputImage"
            type="file"
            value="사진"
            placeholder="사진"
            @change="updateImg"
            v-if="boardType"
          />
        </div>
        <!-- <img class="board__create__button board__create__button-img" src="@/assets/file.png" /> -->
        <!-- 서버에 요청 보내기 -->
        <div class="board__create__button board__create__button-a" @click="createBoard">
          <p>게시하기</p>
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
  name: "BoardCreate",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  mounted() {
    if (this.$route.path === "/notifyCreate") {
      this.type = 0;
    } else {
      this.type = 1;
    }
  },
  data() {
    return {
      boardType: this.$route.params.boardType,
      content: "",
      subject: "",
      image: "",
      type: 1,
      filename: "does not exist file",
    };
  },
  methods: {
    createBoard() {
      var frm = new FormData();
      var files = this.image;

      for (let i = 0; i < files.length; i++) {
        frm.append("imgs", files[i]);
      }
      frm.append("subject", this.subject);
      frm.append("content", this.content);
      frm.append("userNo", this.userInfo.userNo);
      frm.append("boardType", this.type);

      http
        .post("board", frm, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
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
.board__create {
  display: flex;
  align-items: center;
  flex-direction: column;
}
.board__create input:focus,
textarea:focus {
  outline: none;
}
/* .board__create__title {
  text-align: left;
  width:100%;
  margin-bottom: 20px;
  margin-left: 40%;
} */
.board__create__hr {
  color: lightgray;
  width: 100%;
  opacity: 0.4;
}
.board__create__box {
  margin-top: 40px;
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.board__create__box * {
  margin: 0px;
}
.board__create__box input {
  width: clac(100% - 60px);
  padding: 12px 30px;
  border-radius: 0px;
  border: 0px solid var(--color-lightgray);
}
.board__create__box textarea {
  width: calc(100% - 60px);
  height: 20em;
  padding: 30px;
  border: 0px solid var(--color-lightgray);
}
.board__create__subject {
  font-size: 32px;
  border: 10px solid black;
}
.board__create__content {
  font-size: 18px;
  height: 50%;
}

.board__create__img-btn {
  border-radius: 8px;
  width: 300px;
  padding: 0px;
  margin: 0px;
  cursor: pointer;
}

.board__create__footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 96%;
  padding: 0 2%;
  height: 60px;
  border: 0px solid var(--color-lightgray);
  background-color: var(--color-white);
}
.board__create__button {
  width: 40px;
  height: 40px;
  cursor: pointer;
}
.board__create__button-a {
  font-size: 20px;
  height: auto;
  width: auto;
}
</style>
