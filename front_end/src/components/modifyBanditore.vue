<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Modify Banditore</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertBanditore" v-on:submit.prevent>
            <div class="form-group">
              <p>id:</p>
              <input v-model="banditore.id" placeholder="id" name="id">
              <p>nome:</p>
              <input v-model="banditore.nome" placeholder="nome" name="nome">
              <p>settore:</p>
              <input v-model="banditore.settore" placeholder="settore" name="settore">
            </div>
            <button
                @click="modifyBanditore"
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
    modifyBanditore() {
      const form = document.getElementById("insertBanditore");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/modifyBanditore", {
            params: {
              id : formData.get('id'),
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