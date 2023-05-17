import axios from "axios";

export default axios.create({
  // baseURL: "http://192.168.31.78/", // samsung
  baseURL: "http://192.168.0.4/", // home
  headers: {
    "Content-Type": "application/json",
  },
});
