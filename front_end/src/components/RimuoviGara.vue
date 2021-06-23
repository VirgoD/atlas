<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Gare</h2>
    <div class="" style="text-align:right">
        <form id="gare-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca gara" name="gareName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchGara">Ricerca</button>
        </form>
      <form id="rimuoviGara" v-on:submit.prevent>
        <input type="text" placeholder="Rimuovi gara" name="gareName" />
        <button type="submit" class="btn btn-primary btn-sm mt-3" @click="cancellaGara">Ricerca</button>
      </form>

    </div>
    <hr/>

    <div class="container px-5">
      <div class=" row ">
        <div
            v-for="gara in gare"
            :key="gara.id">
          {{gara.id}}    {{gara.anno}}    {{gara.banditore}}   {{gara.baseAsta}}   {{gara.data}}    {{gara.nome}}
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
    cancellaGara(){
      const form = document.getElementById("rimuoviGara");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/cancellaGara", {
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