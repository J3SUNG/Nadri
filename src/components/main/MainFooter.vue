<template>
  <footer class="footer">
    <div class="footer__box">
      <h4 class="footer__team">@ Enjoy Trip Team. All rights reserved.</h4>
      <p class="footer__member">Member : JeSeong Lee / YuJeong Kim</p>
      <p class="footer__contact">Contact : wptjd6141@naver.com / kyj8441@gmail.com</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: "MainFooter",
};
</script>

<style>
.footer {
  display: flex;
  justify-content: center;
  width: 100%;
  bottom: 0;
  height: 100px;
  margin: 0px;
  padding: 0px;
  color: var(--color7-lightgray);
  background-color: var(--color8-black);
  position: fixed;
  box-shadow: 0px 0px 5px var(--color6-darkgray);
}
.footer__box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1140px;
  height: 100%;
  margin: 0px;
  padding: 0px;
}
</style>
