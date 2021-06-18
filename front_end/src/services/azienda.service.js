import axios from 'axios';
import authHeader from './auth-header';
import Azienda from "@/components/Azienda";

const API_URL = 'http://localhost:8080/api/v1/';

class AziendaService {

    getAllAziende() {
        return axios.get(API_URL + 'aziende' , {headers: authHeader() })}

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }

    createAzienda(e) {
        return axios.get(API_URL +'addAzienda', {headers: authHeader() })
    }
}

export default new AziendaService();