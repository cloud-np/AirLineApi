import axios from "axios";

const serverInstance = axios.create({
    baseURL: "http://localhost:9191/"
});
export default serverInstance;