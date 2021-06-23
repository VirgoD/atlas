<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">Rimuovi Banditore</h2>
    <div style="text-align:right">
        <form id="banditore-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca banditore" name="banditoreName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchBanditore">Ricerca</button>
        </form>
      <form id="rimuoviBanditore" v-on:submit.prevent>
        <input type="text" placeholder="Rimuovi banditore" name="id" />
        <button type="submit" class="btn btn-primary btn-sm mt-3" @click="cancellaBanditore">Rimuovi</button>
      </form>

    <hr/>

    <div cass="container px-5">
      <div class=" row ">
        <div
            v-for="banditore in banditori"
            :key="banditore.id">
          {{banditore.id}}    {{banditore.nome}}   {{banditore.settore}}

        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import axios from "axios";
import authHeader from "@/services/auth-header";
import BanditoreService from "@/services/banditore.service"

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
      banditori: [],
      id_value: 0,
    };
  },
  mounted() {
    BanditoreService.getAllBanditori().then(
        response => {
          this.banditori = response.data;
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
    searchBanditore() {
      const form = document.getElementById('banditore-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/banditoreSpeficifa", {
            params: {
              titolo: formData.get('banditoreName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.banditori = response.data;
          });
    },
    cancellaBanditore() {
      const form = document.getElementById('rimozioneBanditore');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/cancellaBanditore", {
            params: {
              id: formData.get('id')
            }, headers: authHeader()
          })
          .then((response) => {
            this.banditori = response.data;
          });
    },
  }
}
</script>

<style scoped>

</style>