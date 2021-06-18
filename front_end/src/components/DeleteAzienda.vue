<template>
  <form v-on:submit.prevent>
    <div class="form-group">
      <p>ID:</p>
      <input v-model="azienda.id" placeholder="nome">
    <button
        @click="deleteAzienda"
        type="submit"
        class="btn btn-primary btn-sm mt-3"
    >
      Create
    </button>
    </div>
  </form>
</template>

<script>
export default {
  name: "deleteAzienda"
}
</script>

<style scoped>

</style>