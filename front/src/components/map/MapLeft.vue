<template>
  <div class="map-left">
    <div class="map-left__input__box">
      <input class="map-left__input" placeholder="장소 검색" />
    </div>
  </div>
</template>

<script>
export default {
  name: "MapLeft",
};
</script>

<style>
.map-left {
  width: 400px;
  height: 100vh;
  background-color: gray;
  position: absolute;
  z-index: 10;
  display: flex;
  align-items: center;
  flex-direction: column;
}
.map-left__input__box {
  margin-top: 100px;
}
.map-left__input {
  width: 360px;
  height: auto;
  border: solid 2px var(--color-main);
  border-radius: 10px;
}
</style>
