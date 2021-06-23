
<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">Rimuovi Aziende</h2>
    <div class="" style="text-align:left">
      <form id="azienda-search" v-on:submit.prevent>
        <input type="text" placeholder="Ricerca azienda" name="aziendaName" />
        <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchAzienda">Ricerca</button>
      </form>
      <form id="rimuoviAzienda" v-on:submit.prevent>
        <input type="text" placeholder="Rimuovi azienda" name="id" />
        <button type="submit" class="btn btn-primary btn-sm mt-3" @click="cancellaAzienda">Rimuovi</button>
      </form>
      <hr/>

      <div cass="container px-5">
        <div class=" row ">
          <div
              v-for="azienda in aziende"
              :key="azienda.id">
            {{azienda.id}}    {{azienda.amministratore}}   {{azienda.nome}}   {{azienda.piva}}     {{azienda.settore}}

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
    searchAzienda() {
      const form = document.getElementById('azienda-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/aziendaSpecifico", {
            params: {
              titolo: formData.get('aziendaName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.aziende = response.data;
          });
    },
    cancellaAzienda(){
      const form = document.getElementById("rimuoviAzienda");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/deleteAzienda", {
            params: {
              id: formData.get('id')
            }, headers: authHeader()
          })

    }
  }
}
</script>

<style scoped>

</style>