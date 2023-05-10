<template>
  <div class="error">
    <div class="error__box">
      <TheLogo />
      <p class="error__code">
        죄송합니다. 페이지를 사용할 수 없습니다. <br />
        클릭하신 링크가 잘못되었거나 페이지가 삭제되었습니다.
      </p>
      <router-link to="/"> <p class="error__home">Enjoy Trip으로 돌아가기</p></router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "TheError",
};
</script>

<style>
.error {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 70%;
}
.error__box {
  display: flex;
  width: 600px;
  height: 300px;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  background-color: white;
  border-radius: 20px;
  box-shadow: 0px 0px 5px #444;
  font-weight: bold;
}
.error__code {
  font-size: 24px;
  padding-bottom: 24px;
}
.error__home {
  font-size: 24px;
}
.error__home:hover {
  color: rgb(255, 203, 106);
}
</style>
