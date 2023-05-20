<template>
  <div class="plan__create">
    <!-- <h2 class="plan__create__title">게시글 작성</h2> -->
    <div class="plan__create__box">
      <input class="plan__create__subject" placeholder="제목을 입력하세요" v-model="subject" />
      <hr class="plan__create__hr" />
      <textarea
        class="plan__create__content"
        placeholder="내용을 입력하세요"
        v-model="content"
      ></textarea>
      <div class="plan__create__footer">
        <img class="plan__create__button plan__create__button-img" src="@/assets/file.png" />
        <!-- 서버에 요청 보내기 -->
        <div class="plan__create__button plan__create__button-a" @click="createPlan">
          <router-link :to="{ name: 'AppPlan' }">게시하기</router-link>
        </div>
      </div>
    </div>
    <!-- <input @change="upload" multiple accept="image/*" type="file" id="file" class="inputfile" /> -->
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "PlanCreate",
  data() {
    return {
      planType: this.$route.params.planType,
      content: "",
      subject: "",
    };
  },
  methods: {
    createPlan() {
      let item = {
        planType: this.planType,
        content: this.content,
        subject: this.subject,
      };
      http.post(`plan`, JSON.stringify(item)).then(() => {
        if (this.planType === 1) {
          this.$router.push({ name: "AppPlan" });
        } else {
          this.$router.push({ name: "AppNotify" });
        }
      });
    },
  },
};
</script>

<style>
.plan__create {
  display: flex;
  align-items: center;
  flex-direction: column;
}
.plan__create input:focus,
textarea:focus {
  outline: none;
}
.plan__create__title {
  margin-bottom: 20px;
}
.plan__create__hr {
  color: lightgray;
  width: 100%;
  opacity: 0.4;
}
.plan__create__box {
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.plan__create__box * {
  margin: 0px;
}
.plan__create__box input {
  width: clac(100% - 60px);
  padding: 12px 30px;
  border-radius: 0px;
  border: 0px solid var(--color-lightgray);
}
.plan__create__box textarea {
  width: calc(100% - 60px);
  height: 20em;
  padding: 30px;
  border: 0px solid var(--color-lightgray);
}
.plan__create__subject {
  font-size: 40px;
  border: 10px solid black;
}
.plan__create__content {
  font-size: 20px;
  height: 50%;
}
.plan__create__footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 96%;
  padding: 0 2%;
  height: 60px;
  border: 0px solid var(--color-lightgray);
  background-color: var(--color-white);
}
.plan__create__button {
  width: 40px;
  height: 40px;
  cursor: pointer;
}
.plan__create__button-a {
  height: auto;
  width: auto;
}
</style>
