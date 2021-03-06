import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/v1/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getDefaultBoard() {
    return axios.get(API_URL + 'default', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();