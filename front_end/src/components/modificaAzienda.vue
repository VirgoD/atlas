<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Azienda</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertAzienda" v-on:submit.prevent>
            <div class="form-group">
              <p>id:</p>
              <input v-model="azienda.id" placeholder="id" name="id">
              <p>nome:</p>
              <input v-model="azienda.nome" placeholder="nome" name="nome">
              <p>piva:</p>
              <input v-model="azienda.pIva" placeholder="pIva" name="pIva">
              <p>amministrazione:</p>
              <input v-model="azienda.amministrazione" placeholder="amministrazione" name="amministrazione">
              <p>CURATORE ID:</p>
              <input v-model="azienda.settore" placeholder="settore" name="settore">
              </div>
            <button
                @click="modifyAzienda"
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
  name: "AddAzienda",
  data() {
    return {
      azienda: {
        nome: "",
        piva: "",
        amministrazione: "",
        settore: ""
      },
    };
  },

  methods: {
    modifyAzienda() {
      const form = document.getElementById("insertAzienda");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/modifyAzienda", {
            params: {
              id: formData.get('id'),
              nome: formData.get('nome'),
              pIva: formData.get('pIva'),
              amministrazione: formData.get('amministrazione'),
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