import axios from 'axios';
import authHeader from './auth-header';
import Gare from "@/components/Gara";

const API_URL = 'http://localhost:8080/api/v1/';

class GaraService {
    getAllGare() {
        return axios.get(API_URL + 'collezioni', {headers: authHeader() })}

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}

export default new GaraService();