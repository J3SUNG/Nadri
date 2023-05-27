<template>
  <footer class="footer">
    <div class="footer__box">
      <p class="footer__team">@ 나들이 Team. All rights reserved.</p>
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
  position: absolute;
  bottom: 0;
  justify-content: center;
  width: 100%;
  bottom: 0;
  height: 80px;
  margin: 0px;
  padding: 0px;
  background-color: var(--color-black);
  box-shadow: 0px 0px 5px var(--color-darkgray);
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
.footer__box p {
  color: var(--color-white);
}
</style>
