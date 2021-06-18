<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Banditore</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertBanditore" v-on:submit.prevent>
            <div class="form-group">
              <p>nome:</p>
              <input v-model="banditore.nome" placeholder="nome" name="nome">
              <p>settore:</p>
              <input v-model="banditore.settore" placeholder="settore" name="settore">
              <p>TOTALE IMPORTO BASE GARE:</p>
              <p>TOTALE IMPORTO FINALE GARE:</p>
            </div>
            <button
                @click="createBanditore"
                type="submit"
                class="btn btn-primary btn-sm mt-3"
            >Create</button>
          </form>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import authHeader from "@/services/auth-header";

export default {
  name: "AddArtist",
  data() {
    return {
      banditore: {
        nome: "",
        settore: ""
      },
    };
  },

  methods: {
    createBanditore() {
      const form = document.getElementById("insertBanditore");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/addBanditore", {
            params: {
              nome: formData.get('nome'),
              settore: formData.get('settore')
            }, headers: authHeader()}) //TODO Append dei parametri da far passare
          .then((response) => {
            console.log(response);
          });

      this.$router.push("/home");

      return false;
    }

}
}
</script>

<style scoped>

</style>