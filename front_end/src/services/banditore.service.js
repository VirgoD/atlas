import axios from 'axios';
import authHeader from './auth-header';
import Azienda from "@/components/Azienda";

const API_URL = 'http://localhost:8080/api/v1/';

class BanditoreService {
    getAllBanditori() {
        return axios.get(API_URL + 'banditori', {headers: authHeader() })}

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}

export default new BanditoreService();