<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Gara</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertGara" v-on:submit.prevent>
            <div class="form-group">
              <p>ID:</p>
              <input v-model="gara.id" placeholder="id" name="id">
              <p>Anno:</p>
              <input v-model="gara.anno" placeholder="Anno" name="anno">
              <p>Banditore ID:</p>
              <input v-model="gara.banditore" placeholder="banditore" name="banditore">
              <p>Base Asta:</p>
              <input v-model="gara.baseAsta" placeholder="Base Asta" name="baseAsta">
              <p>Data Bando:</p>
              <input v-model="gara.data" placeholder="Data" name="data">
              <p>NOME:</p>
              <input v-model="gara.nome" placeholder="nome" name="nome">
            </div>
            <button
                @click="createGara"
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
  name: "AddGara",
  data() {
    return {
      gara: {
        id: "",
        anno: "",
        banditore:"",
        baseAsta: "",
        data: "",
        nome: ""
      },
    };
  },

  methods: {
    createGara() {
      const form = document.getElementById("insertGara");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/addGara", {
            params: {
              id: formData.get('id'),
              anno: formData.get('anno'),
              banditore: formData.get('baseAsta'),
              baseAsta: formData.get('baseAsta'),
              data: formData.get('data'),
              nome: formData.get('nome')
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