<template>
  <div class="logo">
    <img class="logo__img" alt="page logo" src="@/assets/logo.png" />
    <h3 class="logo__text">Enjoy Trip!</h3>
  </div>
</template>

<script>
export default {
  name: "TheLogo",
};
</script>

<style>
.logo {
  display: flex;
  align-items: center;
}
.logo__img {
  width: 50px;
  height: 50px;
}
.logo__text {
  margin-left: 10px;
}
</style>
