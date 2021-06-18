<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Gare</h2>
    <div class="" style="text-align:right">
      <div v-if="showAdminBoard" class="navbar-nav ml-auto">
        <form id="gare-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca gara" name="gareName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchGara">Ricerca</button>
        </form>

        <router-link class="btn btn-outline-success btn-sm" to="/addGare">Inserisci Garea
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/modificaGare">Modifica Garea
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/deleteGare">Elimina Garea
        </router-link>
      </div>
    </div>
    <hr/>

    <div class="">
      <div class=" row ">
        <div
            v-for="gara in gare"
            :key="gara.id"
        >
          {{gara.id}}    {{gara.nome}}    {{gara.id}}   {{gara.luogoNascita}}   {{gara.dataNascita}}    {{gara.luogoMorte}}        {{gara.dataMorte}}        {{gara.natzionalita}}

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


    deleteGara(id, event) {
      console.log(id);
      axios.delete("http://localhost:8080/api/v1/deleteGara/" + id).then((response) => {
        console.log(response);
      });
      event.target.parentElement.parentElement.parentElement.className =
          "animate__animated animate__bounceOutUp";
      setTimeout(function() {
        event.target.parentElement.parentElement.remove();
      }, 1000);
    },
    updateGara(id) {
      this.$router.push({ path: "/garaUpdate/" + id });
    },
  }
}
</script>

<style scoped>

</style>