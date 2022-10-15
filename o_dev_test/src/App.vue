<template>
  <main>
    <div v-if="!loading" class="userList">
      <div v-for="user in users" :key="user?.id">
        <PersonListItem
          v-model:name="user.name"
          v-model:age="user.age"
          :id="user.id"
          @delete="deleteUser"
        ></PersonListItem>
      </div>
      <button @click="addInputFields" class="addUser">+ Add</button>
    </div>
    <div class="container displayRight">
      <button @click="fetchPersonListItems" class="reload">Reload</button>
      <button @click="savePersonListArray" class="save">Save</button>
    </div>
  </main>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import type { IUser } from "./interfaces/user";
import PersonListItem from "./components/PersonListItem.vue";

const users = ref<IUser[]>([]);
const loading = ref(false);
onMounted(() => {
  fetchPersonListItems();
});

const addInputFields = () => {
  users.value.push({
    name: "",
    id: Date.parse(Date()) + Math.random() * 99,
    age: "",
  });
};

const fetchPersonListItems = () => {
  fetch("https://jsonplaceholder.typicode.com/users")
    .then((res) => res.json())
    .then((res) => {
      loading.value = false;
      users.value = res;
      users.value.map((user: IUser) => {
        user.age = Math.floor(Math.random() * 90);
        return user;
      });
    });
};

const savePersonListArray = () => {
  const data = JSON.stringify(users.value);
  window.localStorage.setItem("usersFile", data);
  // console.log(JSON.parse(window.localStorage.getItem("usersFile")));
};

const deleteUser = (userId: number): void => {
  const index = users.value.findIndex((user) => user.id === userId);
  users.value.splice(index, 1);
};
</script>

<style>
main {
  max-width: 30em;
  margin: auto;
}
.container {
  display: flex;
}
.user input {
  border: 2px solid green;
  min-height: 2em;
  margin: 5px;
  padding: 0 10px;
}

button {
  border: 2px solid green;
  min-height: 2em;
  margin: 5px;
  background-color: white;
}
button:hover {
  border: 2px solid red;
  min-height: 2em;
  margin: 5px;
  background-color: rgb(234, 234, 234);
}

.displayRight {
  justify-content: right;
}
</style>
