<template>
  <link rel="stylesheet" href="/css/components/header.css">
  <Header/>
  <div class="grid-container">
    <div class="grid-container__content">
      <Navigation :pagePath="pagePath"/>
      <router-view class="grid-container__view"></router-view>
    </div>
  </div>
</template>

<script setup>
import Header from "@/components/Header.vue";
import Navigation from "@/components/Navigation.vue";
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
