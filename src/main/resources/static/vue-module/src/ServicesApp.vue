<template>
  <link rel="stylesheet" href="/css/app/components/header.css">
  <div class="grid-container" style="height: 100vh; display: grid; grid-template-rows: auto auto 1fr">
    <Header/>
    <Navigation :pagePath="pagePath"/>
    <router-view></router-view>
  </div>
</template>

<script setup>
import Header from "@/components/services/Header.vue";
import Navigation from "@/components/services/Navigation.vue";
import {ref, watch} from "vue";
import {useRoute} from "vue-router";

const pagePath = ref('');
const route = useRoute();

function parsePageKey(path) {
  return path.substring(path.lastIndexOf('/') + 1) || 'none';
}

pagePath.value = parsePageKey(route.path);

watch(() => route.path, (newPath) => {
  pagePath.value = parsePageKey(newPath);
});
</script>

<style>
</style>
