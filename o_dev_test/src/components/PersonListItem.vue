<template>
  <div class="container user">
    <input
      :value="name"
      placeholder="Navn"
      type="text"
      name="userName"
      id="userNameId"
      @input="$emit('update:name', String($event.target.value))"
    />
    <input
      type="text"
      placeholder="Alder"
      name="userAge"
      id="userAgeId"
      :value="age"
      @input="$emit('update:age', Number($event.target.value))"
    />
    <button @click="deleteUser(id)" class="delete">Slett Bruker</button>
  </div>
</template>

<script setup lang="ts">
import type { IUser } from "../interfaces/user";
const props = defineProps<{
  name: string;
  id: number;
  age: number | "";
}>();
const emit = defineEmits<{
  (e: "delete", id: number): void;
  (event: "update:name", payload: string): void;
  (event: "update:age", payload: number): void;
}>();

const deleteUser = (userId: number) => {
  emit("delete", userId);
};
</script>
