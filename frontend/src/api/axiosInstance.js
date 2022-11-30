import axios from "axios";
import env from "react-dotenv";

const serverInstance = axios.create({
    baseURL: "http://localhost:9090/api/v1"
});
export default serverInstance;