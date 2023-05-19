<template>
  <div class="notify">
    <div class="notify__box">
      <h1>공지사항</h1>
      <div class="notify__write">
        <button class="notify__write-button" @click="moveNotifyCreate">글쓰기</button>
      </div>
      <!-- <div v-if="boards.length"> -->
      <table class="notify__table">
        <colgroup class="notify__colgroup">
          <col width="200px" />
          <col width="512px" />
          <col width="200px" />
        </colgroup>
        <thead>
          <tr class="notify__table__tr">
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <!-- <notify-list-item></notify-list-item> -->
          <notify-list-item
            v-for="board in boards"
            :key="board.boardNo"
            :board="board"
            class="notify__table__data"
          ></notify-list-item>
        </tbody>
      </table>
      <!-- <div v-else>게시글이 없습니다.</div> -->
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import NotifyListItem from "@/components/notify/NotifyListItem.vue";

export default {
  name: "NotifyList",
  components: {
    NotifyListItem,
  },
  data() {
    return {
      boards: [],
      type: "0",
    };
  },
  created() {
    http.get(`board?type=${this.type}`).then((response) => {
      this.boards = response.data;
    });
  },
  methods: {
    moveNotifyCreate() {
      this.$router.push({ name: "AppNotifyCreate", params: { boardType: this.type } });
    },
  },
};
</script>

<style>
.notify {
  width: 100%;
  display: flex;
  justify-content: center;
}
.notify__box {
  width: 80%;
  height: 100%;
}
.notify__table {
  width: 100%;
}
.notify__tr {
  height: 50px;
}
.notify__colgroup {
  width: 100%;
}
.notify__write {
  display: flex;
  justify-content: end;
}
.notify__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
.notify__table__tr {
  height: 50px;
}
.notify__table__data {
  height: 50px;
}
.notify__table__tr th {
  border-bottom: 1px solid var(--color-lightgray);
  border-top: 1px solid var(--color-lightgray);
}
</style>
