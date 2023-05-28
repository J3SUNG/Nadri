// const { defineConfig } = require("@vue/cli-service");
// module.exports = defineConfig({
//   transpileDependencies: true
// })

module.exports = {
  devServer: {
    // proxy: process.env.VUE_APP_API_BASE_URL,
    // proxy: "https://www.joongang.co.kr",
    proxy: {
      "/api": {
        target: "https://www.joongang.co.kr",
        // target: "https://www.naver.com",
        changeOrigin: true,
      },
    },
  },
};
