<template>
  <p>{{ name }} and {{ age }}</p>
</template>
;

<script>
export default {
  name: "userNames",
  props: ["name", "age"],
};
</script>

<style></style>
