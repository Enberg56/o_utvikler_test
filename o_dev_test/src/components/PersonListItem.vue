<template>
  <div class="container user">
    <input
      :value="name"
      placeholder="Navn"
      type="text"
      name="userName"
      id="userNameId"
      @input="
        $emit('update:name', String(($event.target as HTMLInputElement).value))
      "
    />
    <input
      type="text"
      placeholder="Alder"
      name="userAge"
      id="userAgeId"
      :value="age"
      @input="
        $emit('update:age', Number(($event.target as HTMLInputElement).value))
      "
    />
    <button @click="deleteUser(id)" class="delete">Slett Bruker</button>
  </div>
</template>

<script setup lang="ts">
import type { IUser } from "../interfaces/user";
defineProps<IUser>();

const emit = defineEmits<{
  (e: "delete", id: number): void;
  (event: "update:name", payload: string): void;
  (event: "update:age", payload: number): void;
}>();

const deleteUser = (userId: number) => {
  emit("delete", userId);
};
</script>
