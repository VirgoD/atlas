<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Gare</h2>
    <div class="" style="text-align:left">
        <form id="gare-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca gara" name="gareName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchGara">Ricerca</button>
        </form>
      <div v-if="showAdminBoard" class="navbar-nav ml-auto">
        <router-link class="btn btn-outline-success btn-sm" to="/addGara">Inserisci Gara
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/modifyaGara">Modifica Gara
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/rimuoviGare" style="color: red; border-color: red;">Elimina Gara
        </router-link>
      </div>
    <hr/>

      <div cass="container px-5">
        <div class=" row ">
          <div
              v-for="gara in gare"
              :key="gara.id">
            {{gara.id}}         {{gara.anno}}          {{gara.banditore}}              {{gara.baseAsta}}        {{gara.data}}       {{gara.nome}}

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GaraService from '../services/gara.service';
import axios from "axios";
import authHeader from "@/services/auth-header";


export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }
      return false;
    },
  },
  data() {
    return {
      gare: [],
      id_value: 0,
    };
  },
  mounted() {
    GaraService.getAllGare().then(
        response => {
          this.gare = response.data;
        },
        error => {
          this.content =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
        }
    );
  },
  methods : {
    searchGara() {
      const form = document.getElementById('gara-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/garaSpecifica", {
            params: {
              nome: formData.get('garaName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.gare = response.data;
            console.log("GAREI", this.gare)
          });
    },
  }
}
</script>

<style scoped>

</style>