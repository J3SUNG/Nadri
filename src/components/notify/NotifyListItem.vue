<template>
  <tr>
    <!-- <td>{{ board.boardNo }}</td> -->
    <!-- <td>{{ board.boardType }}</td> -->
    <td>{{ board.subject }}</td>
    <td>{{ board.userName }}</td>
    <td>{{ board.createTime }}</td>
    <td>{{ board.likeCount }}</td>
    <!-- <td>{{ board.content }}</td> -->
    <!-- <td>{{ board.userNo }}</td> -->
  </tr>
</template>

<script>
export default {
  name: "NotifyListItem",
  props: {
    // board: Object,
  },
  data() {
    return {
      board: {
        boardNo: 1,
        boardType: 1,
        createTime: "2023-05-16 00:37",
        subject: "Hello",
        content: "Hi",
        likeCount: "11",
        userNo: 12,
        userName: "jetty",
      },
    };
  },
};
</script>

<style></style>
