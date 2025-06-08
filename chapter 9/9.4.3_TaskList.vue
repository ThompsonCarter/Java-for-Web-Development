<template>
  <ul>
    <li v-for="t in tasks" :key="t.id">{{ t.description }}</li>
  </ul>
</template>

<script>
export default {
  data() { return { tasks: [] }; },
  created() {
    fetch('/api/tasks')
      .then(res => res.json())
      .then(data => this.tasks = data);
  }
}
</script>