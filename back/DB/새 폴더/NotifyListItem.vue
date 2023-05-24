<template>
  <tr class="notify__item" @click="moveNotifyDetail">
    <td class="notify__item__boardNo">{{ board.boardNo }}</td>
    <td class="notify__item__subject">{{ board.subject }}</td>
    <td class="notify__item__createTime">{{ board.createTime }}</td>
  </tr>
</template>

<script>
export default {
  name: "NotifyListItem",
  props: {
    board: Object,
  },
  methods: {
    moveNotifyDetail() {
      this.$router.push({ name: "AppNotifyDetail", params: { boardNo: this.board.boardNo } });
    },
  },
};
</script>

<style>
.notify__item {
  cursor: pointer;
  height: 20px;
}
.notify__item td {
  border-bottom: solid 1px var(--color-lightgray);
}
</style>
