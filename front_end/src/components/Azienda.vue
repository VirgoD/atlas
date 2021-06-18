<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Collections</h2>
    <div class="" style="text-align:right">
      <div v-if="showAdminBoard" class="navbar-nav ml-auto">
        <form id="collection-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca banditore" name="banditoreName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchCollezione">Ricerca</button>
        </form>
      <router-link class="btn btn-outline-success btn-sm" to="/addAzienda">Inserisci Collezione
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/modificaAzienda">Modifica Collezione
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/deleteAzienda">Elimina Collezione
      </router-link>
    </div>
    <hr/>

    <div cass="container px-5">
      <div class=" row ">
        <div
            v-for="azienda in aziende"
            :key="azienda.id">
          {{azienda.titolo}}    {{azienda.anno}}   {{azienda.descrizione}}   {{azienda.curatoreId}}

        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import AziendaService from '../services/azienda.service';
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
      aziende: [],
      id_value: 0,
    };
  },
  mounted() {
    AziendaService.getAllAziende().then(
        response => {
          this.aziende = response.data;
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
    searchCollezione() {
      const form = document.getElementById('azienda-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/banditoreSpecifico", {
            params: {
              titolo: formData.get('banditoreName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.aziende = response.data;
          });
    },

    deleteAzienda(id, event) {
      console.log(id);
      axios.delete("http://localhost:8080/api/v1/delete" + id).then((response) => {
        console.log(response);
      });
      event.target.parentElement.parentElement.parentElement.className =
          "animate__animated animate__bounceOutUp";
      setTimeout(function() {
        event.target.parentElement.parentElement.remove();
      }, 1000);
    },

    updateAzienda(id) {
      this.$router.push({ path: "/aziendaUpdate/" + id });
    },
  }
}
</script>

<style scoped>

</style>