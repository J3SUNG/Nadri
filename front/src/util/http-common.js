import axios from "axios";

export default axios.create({
  // baseURL: "http://192.168.31.78:7777/", // samsung
  baseURL: process.env.VUE_APP_API_BASE_URL, // home
  headers: {
    "Content-Type": "application/json",
  },
});
