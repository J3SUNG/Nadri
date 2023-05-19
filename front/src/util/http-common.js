import axios from "axios";

export default axios.create({
  baseURL: "http://192.168.31.78/", // samsung
  // baseURL: "http://192.168.0.4/", // home
  // baseURL: "http://59.151.232.152:7777/", // home2
  headers: {
    "Content-Type": "application/json",
  },
});
