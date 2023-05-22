import axios from "axios";

export default axios.create({
  // baseURL: "http://192.168.31.78:7777/", // samsung
  baseURL: "http://59.151.232.152:7777/", // home
  headers: {
    "Content-Type": "application/json",
  },
});
